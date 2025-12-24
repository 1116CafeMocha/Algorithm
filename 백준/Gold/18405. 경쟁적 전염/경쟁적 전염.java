import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[][] map;
	static Queue<int[]>[] que;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		que = new ArrayDeque[K+1];
		
		for(int i=1; i<=K; i++) {
			que[i] = new ArrayDeque<>();
		}
		
		for(int r=1; r<=N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1; c<=N; c++) {
				int now = Integer.parseInt(st.nextToken());
				map[r][c] = now;
				
				if(now != 0) {
					que[now].offer(new int[] {r, c});
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		while(S-- > 0) {
			for(int i=1; i<=K; i++) {
				if(que[i].isEmpty()) continue;
				
				int size = que[i].size();
				
				for(int j=0; j<size; j++) {
					int[] now = que[i].poll();
					int nowR = now[0];
					int nowC = now[1];
					
					for(int k=0; k<4; k++) {
						int nextR = nowR + dr[k];
						int nextC = nowC + dc[k];
						
						if(nextR < 1) continue;
						if(nextC < 1) continue;
						if(nextR > N) continue;
						if(nextC > N) continue;
						
						if(map[nextR][nextC] != 0) continue;
						
						map[nextR][nextC] = i;
						que[i].offer(new int[] {nextR, nextC});
					}
				}
			}
		}
		
		bw.write(Integer.toString(map[X][Y]));
		
		bw.flush();
		bw.close();
	}

}
