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
	static int N, E;
	static List<Node>[] graph;
	static final int INF = 1_000_000_000;
	
	static class Node{
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
		E = Integer.parseInt(input[1]);
		
		graph = new ArrayList[N + 1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			input = br.readLine().split(" ");
			
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);
			
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		
		input = br.readLine().split(" ");
		int v1 = Integer.parseInt(input[0]);
		int v2 = Integer.parseInt(input[1]);
		
		int[] distFrom1 = dijkstra(1);
		int[] distFromV1 = dijkstra(v1);
		int[] distFromV2 = dijkstra(v2);
		
		long path1 = (long)distFrom1[v1] + distFromV1[v2] + distFromV2[N];
		long path2 = (long)distFrom1[v2] + distFromV2[v1] + distFromV1[N];
		
		long answer = Math.min(path1, path2);
		
		if(answer >= INF) bw.write("-1");
		else bw.write(Long.toString(answer));

		bw.flush();
		bw.close();
	}
	
	static int[] dijkstra(int start) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
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

}
