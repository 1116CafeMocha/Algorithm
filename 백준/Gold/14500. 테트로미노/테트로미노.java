import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer=0, MAX=0;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				MAX = Math.max(MAX, map[r][c]);
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				visited[r][c] = true;
				dfs(r, c, 1, map[r][c]);
				visited[r][c] = false;
				
				checkT(r, c);
			}
		}
		
		bw.write(Integer.toString(answer));
		
		bw.flush();
		bw.close();
	}
	
	static void dfs (int R, int C, int depth, int sum) {
		// 남은 칸을 모두 MAX값으로 채워도 ansewr보다 커지지 않으면 끝
		if(sum + MAX * (4 - depth) <= answer) return;
		
		if(depth == 4) {
			if(sum > answer) answer = sum;
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nowR = R + dr[i];
			int nowC = C + dc[i];
			
			if(nowR < 0) continue;
			if(nowC < 0) continue;
			if(nowR >= N) continue;
			if(nowC >= M) continue;
			
			if(visited[nowR][nowC]) continue;
			
			visited[nowR][nowC] = true;
			
			dfs(nowR, nowC, depth + 1, sum + map[nowR][nowC]);
			visited[nowR][nowC] = false;
		}
	}
	
	// T 모양 확인
	static void checkT(int R, int C) {
		int center = map[R][C];
		int sum = 0;
		int count = 0;
		int minNeighbor = Integer.MAX_VALUE;
		
		for(int i=0; i<4; i++) {
			int nowR = R + dr[i];
			int nowC = C + dc[i];
			
			if(nowR < 0) continue;
			if(nowC < 0) continue;
			if(nowR >= N) continue;
			if(nowC >= M) continue;
			
			int val = map[nowR][nowC];
			sum += val;
			count++;
			if(val < minNeighbor) minNeighbor = val;
		}
		
		// T 모양 불가
		if(count < 3) return;
		
		// 중심 + 가까운 3칸
		if(count == 3) answer = Math.max(answer, center + sum);
		// 가까운 칸이 4개면 그 중 가장 작은 것을 제외
		else answer = Math.max(answer, center + sum - minNeighbor);
	}

}