import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	static int N, M, X;
	static List<Edge>[] graph;
	static int[] dist;
	
	static int INF = 1_000_000_000;
	
	static class Edge {
		int to;
		int weight;
		
		Edge(int to, int weight){
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		X = Integer.parseInt(input[2]);
		
		graph = new ArrayList[N+1];
		dist = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			int T = Integer.parseInt(input[2]);
			
			graph[A].add(new Edge(B, T));
		}
		
		int answer = 0;
		
		for(int i=1; i<=N; i++) {
			int sum = dijkstra(i, X) + dijkstra(X, i);
			answer = Math.max(answer, sum);
		}
		
		bw.write(Integer.toString(answer));
		
		bw.flush();
		bw.close();
	}
	
	static int dijkstra(int start, int end) {
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
		pq.offer(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			int nowTo = now.to;
			int nowDist = now.weight;
			
			if(nowDist > dist[nowTo]) continue;
			
			for(Edge next : graph[nowTo]) {
				int nextDist = nowDist + next.weight;
				
				if(nextDist < dist[next.to]) {
					dist[next.to] = nextDist;
					pq.offer(new Edge(next.to, nextDist));
				}
			}
		}
		return dist[end];
	}
	
}
