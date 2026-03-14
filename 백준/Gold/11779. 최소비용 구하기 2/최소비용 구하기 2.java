import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라
// 경로 저장

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<Edge>[] graph;
	static int[] dist, path;
	
	static class Edge {
		int to, cost;
		
		Edge(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
	}
	
	static class Node implements Comparable<Node> {
        int city, cost;

        Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		for(int i=0; i<=N; i++) graph[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int busNum = Integer.parseInt(st.nextToken());
			int cityNum = Integer.parseInt(st.nextToken());
			int busCost = Integer.parseInt(st.nextToken());
			
			graph[busNum].add(new Edge(cityNum, busCost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1];
		path = new int[N+1];
		
		Arrays.fill(dist, INF);
		
		dijkstra(start);
		
		bw.write(dist[end] + "\n");
		
		ArrayList<Integer> answer = new ArrayList<>();
		int now = end;
		while(now != 0) {
			answer.add(now);
			now = path[now];
		}
		Collections.reverse(answer);
		
		bw.write(answer.size() + "\n");
		
		for(int num : answer) bw.write(num + " ");
		
		bw.flush();
		bw.close();
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int nowCity = now.city;
			int nowCost = now.cost;
			
			if(dist[nowCity] < nowCost) continue;
			
			for(Edge next : graph[nowCity]) {
				if(dist[next.to] > dist[nowCity] + next.cost) {
					dist[next.to] = dist[nowCity] + next.cost;
					path[next.to] = nowCity;
					pq.offer(new Node(next.to, dist[next.to]));
				}
			}
		}
	}
	
}