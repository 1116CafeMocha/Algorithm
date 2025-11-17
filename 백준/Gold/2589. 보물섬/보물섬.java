import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static int N, M;
	static boolean[][] map;
	static boolean[][] visited;
	static int answer;
	
	static Queue<int[]> lands;
	static Queue<int[]> que;
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		map = new boolean[N][M];
		visited = new boolean[N][M];
		
		answer = 0;
		
		lands = new ArrayDeque<>();
		que = new ArrayDeque<>();
		
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<M; c++) {
				char now = str.charAt(c);
				if(now == 'L') {
					map[r][c] = true;
					lands.offer(new int[] {r, c});
				}				
			}
		}
		
		for(int[] now : lands) {
			bfs(now[0], now[1]);
		}
		
		bw.write(Integer.toString(answer));

		bw.flush();
		bw.close();
	}
	
	static void bfs(int R, int C) {
		que.clear();
		
		for(int i=0; i<N; i++) {
			Arrays.fill(visited[i], false);
		}
		
		que.offer(new int[] {R, C, 0});
		visited[R][C] = true;
		
		int maxDist = 0;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			int nowR = now[0];
			int nowC = now[1];
			int nowDist = now[2];
			
			maxDist = Math.max(maxDist, nowDist);
			
			for(int i=0; i<4; i++) {
				int nextR = nowR + dr[i];
				int nextC = nowC + dc[i];
				
				if(nextR < 0) continue;
				if(nextC < 0) continue;
				if(nextR >= N) continue;
				if(nextC >= M) continue;
				if(!map[nextR][nextC]) continue;
				if(visited[nextR][nextC]) continue;
				
				visited[nextR][nextC] = true;
				
				que.offer(new int[]{nextR, nextC, nowDist + 1});
			}
		}
		
		answer = Math.max(answer, maxDist);
	}
}
