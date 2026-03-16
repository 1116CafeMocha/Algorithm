import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 처음에 한 대가 감염됨
// 총 감염 수, 전부 감염되기까지의 시간 구하기 문제!
// 시작 컴퓨터에서 각 컴퓨터까지 다익스트라 돌려서 최대값 찾으면 그게 답임
// 최대값 찾는 시점에 이미 다른 감염 가능한 컴퓨터들은 다 감염된 상태니까 또 더할 필요 없음(착각하지말자)

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static List<Edge>[] graph;
	static int[] dist;
	
	static class Edge {
		int to;
		int cost;
		
		Edge(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
	}
	
	static class Node implements Comparable<Node> {
        int num;
        int dist;

        Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[N+1];
			dist = new int[N+1];
			
			for(int i=0; i<=N; i++) graph[i] = new ArrayList<>();
			
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int S = Integer.parseInt(st.nextToken());
				
				graph[B].add(new Edge(A, S));
			}
			
			dijkstra(C, N);
			
			int count = 0;
			int MAX = 0;
			
			for(int i=1; i<= N; i++) {
				if(dist[i] != INF) {
					count++;
					MAX = Math.max(MAX, dist[i]);
				}
			}
			
			bw.write(count + " " + MAX + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static void dijkstra(int start, int N) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(dist, INF);
		
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.dist > dist[now.num]) continue;
			
			for(Edge next : graph[now.num]) {
				if(dist[next.to] > dist[now.num] + next.cost) {
					dist[next.to] = dist[now.num]+ next.cost;
					pq.offer(new Node(next.to, dist[next.to]));
				}
			}
		}
	}
	
}