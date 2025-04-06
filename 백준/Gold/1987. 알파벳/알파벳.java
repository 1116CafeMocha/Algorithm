import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 1987번. 알파벳

public class Main {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int R, C;
	static int[][] map;
	static boolean[] checked;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		map = new int[R][C];
		checked = new boolean[100];
		max = 0;
		
		for(int r=0; r<R; r++) {
			String str = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = (int) str.charAt(c);
			}
		}
		
		checked[map[0][0]] = true;
		dfs(0, 0, 1);
		
		System.out.println(max);
		
	}
	
	public static void dfs (int startR, int startC, int dist) {
		if(dist > max) {
			max = dist;
		}
		
		for(int i=0; i<4; i++) {
			int nextR = startR + dr[i];
			int nextC = startC + dc[i];
			
			if(nextR<0) continue;
			if(nextC<0) continue;
			if(nextR>=R) continue;
			if(nextC>=C) continue;
			if(checked[map[nextR][nextC]]) continue;
			
			checked[map[nextR][nextC]] = true;
			dfs(nextR, nextC, dist + 1); // ++dist 이런식으로 dist 변수를 바꿔버리면 안 된다!
			checked[map[nextR][nextC]] = false;
		}
	}

}
