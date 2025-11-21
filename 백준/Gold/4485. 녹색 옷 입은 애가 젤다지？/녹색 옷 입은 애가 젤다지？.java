import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[][] dist;
	static final int INF = 1_000_000_000;
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static class Node implements Comparable<Node> {
		int r, c, cost;
		
		Node(int r, int c, int cost){
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = 0;
		
		while(true) {
			num++;
			N = Integer.parseInt(br.readLine());
			
			if(N == 0) break;
			
			map = new int[N][N];
			dist = new int[N][N];
			
			for(int r=0; r<N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					dist[r][c] = INF;
				}
			}
			
			dijkstra();
			
			bw.write("Problem " + num + ": " + dist[N-1][N-1]);
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		dist[0][0] = map[0][0];
		pq.offer(new Node(0, 0, dist[0][0]));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			int nowR = now.r;
			int nowC = now.c;
			int nowCost = now.cost;
			
			if(nowCost > dist[nowR][nowC]) continue;
			if(nowR == N-1 && nowC == N-1) return;
			
			for(int i=0; i<4; i++) {
				int nextR = nowR + dr[i];
				int nextC = nowC + dc[i];
				
				if(nextR < 0) continue;
				if(nextC < 0) continue;
				if(nextR >= N) continue;
				if(nextC >= N) continue;
				
				int nextCost = nowCost + map[nextR][nextC];
				if(nextCost < dist[nextR][nextC]) {
					dist[nextR][nextC] = nextCost;
					pq.offer(new Node(nextR, nextC, nextCost));
				}
			}
		}
	}
	
}
