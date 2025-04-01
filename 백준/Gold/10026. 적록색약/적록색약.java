import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 백준 10026번. 적록색약

public class Main {
	static int N;
	static int[][] mapNormal;
	static int[][] mapWeakness;
	static boolean[][] visited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		N = Integer.parseInt(br.readLine());
		mapNormal = new int[N][N];
		mapWeakness = new int[N][N];
		visited = new boolean[N][N];

		for (int r = 0; r < N; r++) {
			input = br.readLine().split("");

			for (int c = 0; c < N; c++) {
				String now = input[c];
				if (now.equals("G")) {
					mapNormal[r][c] = 1;
				} else if (now.equals("B")) {
					mapNormal[r][c] = 2;
					mapWeakness[r][c] = 1;
				}
			}
		}
		
		int count = 0;
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(visited[r][c]) continue;
				count++;
				dfs(mapNormal, r, c);
			}
		}
		
		System.out.print(count+" ");
		
		// 초기화
		count = 0;
		for(int i=0; i<N; i++) {
			Arrays.fill(visited[i], false);			
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(visited[r][c]) continue;
				count++;
				dfs(mapWeakness, r, c);
			}
		}
		
		System.out.print(count);
	}
	
	public static void dfs(int[][]map, int R, int C) {		
		for(int i=0; i<4; i++) {
			int nextR = R + dr[i];
			int nextC = C + dc[i];
			
			if(nextR < 0) continue;
			if(nextR >= N) continue;
			if(nextC < 0) continue;
			if(nextC >= N) continue;
			if(map[R][C] != map[nextR][nextC]) continue;
			if(visited[nextR][nextC]) continue;
			
			visited[nextR][nextC] = true;
			dfs(map, nextR, nextC);
		}
	}

}
