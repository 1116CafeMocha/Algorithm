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

public class Main {
	static int N, M;
	static long INF = Long.MAX_VALUE / 4;
	static boolean[] visible;
	static List<Node>[] graph;
	
	static class Node {
		int to;
		long weight;
		
		Node(int to, long weight){
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
		
		graph = new ArrayList[N];
		visible = new boolean[N];
		
		for(int i=0; i<N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N-1; i++) {
			int isVisible = Integer.parseInt(st.nextToken());
			
			if(isVisible == 1) {
				// true : 보임, false : 안 보임
				visible[i] = true;
			}
		}
		
		for(int i=0; i<M; i++) {
			input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			long T = Long.parseLong(input[2]);
			
			graph[A].add(new Node(B, T));
			graph[B].add(new Node(A, T));
		}
		
		long[] dist = dijkstra(0);
		
		long answer = dist[N-1];
		
		if(answer == INF) bw.write("-1");
		else bw.write(Long.toString(answer));
		
		bw.flush();
		bw.close();
	}
	
	static long[] dijkstra(int start) {
		long[] dist = new long[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.weight, o2.weight));
		
		pq.offer(new Node(start, 0L));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int now = cur.to;
			long nowDist = cur.weight;
			
			if(visible[now]) continue;
			if(nowDist > dist[now]) continue;
			
			for(Node next : graph[now]) {
				long cost = nowDist + next.weight;
				if(cost < dist[next.to]) {
					dist[next.to] = cost;
					pq.offer(new Node(next.to, cost));
				}
			}
		}
		return dist;
	}
	
}
