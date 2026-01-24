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
	static int INF = 1_000_000_000;
	static int N, D;
	static List<Edge>[] graph;
	
	static class Edge {
        int to, w;
        
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
	
	static class Node implements Comparable<Node> {
        int v, dist;
        Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.dist, other.dist);
        }
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		graph = new ArrayList[D + 1];
		
		for (int i = 0; i <= D; i++) graph[i] = new ArrayList<>();
		
		for (int i = 0; i < D; i++) graph[i].add(new Edge(i + 1, 1));
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int ST = Integer.parseInt(st.nextToken());
			int ED = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			
			if (ST > D || ED > D) continue;
			if (S >= ED - ST) continue;
			graph[ST].add(new Edge(ED, S));
		}
		
		int[] dist = new int[D + 1];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int v = cur.v;
            int d = cur.dist;

            if (d != dist[v]) continue;
            if (v == D) break;

            for (Edge e : graph[v]) {
                int nd = d + e.w;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.add(new Node(e.to, nd));
                }
            }
        }
        
        bw.write(Integer.toString(dist[D]));
		
		bw.flush();
		bw.close();
	}
}
