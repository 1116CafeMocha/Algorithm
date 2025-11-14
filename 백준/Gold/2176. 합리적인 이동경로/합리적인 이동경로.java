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
	static int N, M;
	static List<Node>[] graph;
	static int[] Dist, dp;
	final static int INF = 1_000_000_000;
	
	static class Node {
		int to;
		int weight;
		
		Node(int to, int weight){
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
		
		graph = new ArrayList[N+1];
		dp = new int[N+1];
		
		Arrays.fill(dp, -1);
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			input = br.readLine().split(" ");
			
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			int C = Integer.parseInt(input[2]);
			
			graph[A].add(new Node(B, C));
			graph[B].add(new Node(A, C));
		}
		
		Dist = dijkstra(2);
		
		int answer = dfs(1);
		
		bw.write(Integer.toString(answer));

		bw.flush();
		bw.close();
	}
	
	static int[] dijkstra(int start) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
		
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int now = cur.to;
			int nowDist = cur.weight;
			
			if(nowDist > dist[now]) continue;
			
			for(Node next : graph[now]) {
				int cost = nowDist + next.weight;
				
				if(cost < dist[next.to]) {
					dist[next.to] = cost;
					pq.offer(new Node(next.to, cost));
				}
			}
		}
		
		return dist;
	}
	
	static int dfs(int s) {
		if(s == 2) return 1;
		if(dp[s] != -1) return dp[s];
		
		int sum = 0;
		for(Node now : graph[s]) {
			int t = now.to;
			if(Dist[s] > Dist[t]) {
				sum += dfs(t);
			}
		}
		
		dp[s] = sum;
		return sum;
	}

}
