// 백준 14940번. 쉬운 최단거리

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input;
		
		input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		boolean[][] map = new boolean[N][M];
		int[][] dist = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		Queue<int[]> que = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			Arrays.fill(dist[i], -1);
		}
		
		for(int n=0; n<N; n++) {
			input = br.readLine().split(" ");
			for(int m=0; m<M; m++) {
				int val = Integer.parseInt(input[m]);
				if(val == 0) dist[n][m] = 0;
				if(val > 0) map[n][m] = true;
				if(val == 2) {
					que.add(new int[] {n, m});
					visited[n][m] = true;
					dist[n][m] = 0;
				}
			}
		}
		
		int distVal = 0;
		while(!que.isEmpty()) {
			int queSize = que.size();
			distVal ++;
			
			for(int i=0; i< queSize; i++) {
				int now[] = que.poll();
				
				for(int k=0; k<4; k++) {
					int nextR = now[0] + dr[k];
					int nextC = now[1] + dc[k];
					
					if(nextR < 0) continue;
					if(nextC < 0) continue;
					if(nextR >= N) continue;
					if(nextC >= M) continue;
					
					if(visited[nextR][nextC]) continue;
					if(!map[nextR][nextC]) continue;
					
					visited[nextR][nextC] = true;
					dist[nextR][nextC] = distVal;
					
					que.add(new int[] {nextR, nextC});
				}
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				bw.write(dist[r][c]+" ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

}
