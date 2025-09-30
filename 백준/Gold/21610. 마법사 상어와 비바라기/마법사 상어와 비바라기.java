import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*
map : N*N 격자, 각 칸에 바구니 (1, 1) ~ (N, N)
(게임처럼 양 끝 경계는 이어져 있음)

비바라기 : (N, 1), (N, 2), (N-1, 1), (N-1, 2)에 먹구름 생성
구름에 M 번의 이동 명령 : 방향 d, 거리 s
방향 d : 1~8 (←, ↖, ↑, ↗, →, ↘, ↓, ↙)

이동 프로세스 : 
1. 모든 구름이 d 방향으로 s칸 이동
2. 구름이 있는 칸 + 1
3. 구름 모두 제거
4. 2에서 증가한 칸 : 물복사 (대각선 방향으로 거리가 1 범위 내의 양수 값 개수만큼 해당 칸의 값 증가)
(이동과 다르게 이건 경계 넘어가면 컷)
5. 값이 2 이상인 모든 칸에 구름 생성 후 -2. 전에 구름이 있던 칸과 중복x

메서드 : 구름 생성, 구름 이동, 구름 제거, 비, 물복사
구름 생성 중복 확인용 boolean 배열 필요.
현재 구름 좌표들을 저장할 큐나 리스트 필요. 성능 고려해서 ArrayDeque 사용.
 */

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] prevCloud;
	static Queue<int[]> cloudQueue, rainedQueue;
	
	static int[] dr = {-1, -1, 1, 1};
	static int[] dc = {-1, 1, 1, -1};
	static int[] sr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] sc = {0, -1, -1, 0, 1, 1, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		map = new int[N+1][N+1];
		prevCloud = new boolean[N+1][N+1];
		cloudQueue = new ArrayDeque<>();
		rainedQueue = new ArrayDeque<>();
		
		for(int r=1; r<=N; r++) {
			input = br.readLine().split(" ");
			for(int c=1; c<=N; c++) {
				int val = Integer.parseInt(input[c-1]);
				if(val == 0) continue;
				map[r][c] = val;
			}
		}
		
		// 구름 초기값
		cloudQueue.offer(new int[] {N, 1});
		cloudQueue.offer(new int[] {N, 2});
		cloudQueue.offer(new int[] {N-1, 1});
		cloudQueue.offer(new int[] {N-1, 2});
		
		while(M-- > 0){
			input = br.readLine().split(" ");
			int D = Integer.parseInt(input[0]);
			int S = Integer.parseInt(input[1]);
			
			moveCloud(D, S);
			rain();
			eliCloud();
			waterCopyBug();
			makeCloud();
		}
		
		bw.write(Integer.toString(waterSum()));
		
		bw.flush();
		bw.close();
	}
	
	// 구름 생성
	static void makeCloud() {

		for(int r=1; r<=N; r++) {
			for(int c=1; c<=N; c++) {
				if(map[r][c] >= 2) {
					if(prevCloud[r][c]) continue;
					
					cloudQueue.offer(new int[] {r, c});
					map[r][c] -=2;
				}
			}
		}
	}
	
	// 구름 제거
	static void eliCloud() {
		
		for(int r=1; r<=N; r++) {
			Arrays.fill(prevCloud[r], false);			
		}
		
		while(!cloudQueue.isEmpty()) {
			int[] now = cloudQueue.poll();
			prevCloud[now[0]][now[1]] = true;
		}
	}
	
	// 구름 이동
	static void moveCloud(int d, int s) {
		s %= N;
		int queSize = cloudQueue.size();
		
		while(queSize-- > 0) {
			int[] now = cloudQueue.poll();
			int nextR = border(now[0] + (sr[d] * s));
			int nextC = border(now[1] + (sc[d] * s));
			
			cloudQueue.offer(new int[] {nextR, nextC});
		}
	}
	
	// 맵 경계 잇기
	static int border(int x) {
		x %= N;
		if(x <= 0) x += N;
		
		return x;
	}
	
	// 비
	static void rain() {
		int queSize = cloudQueue.size();
		
		while(queSize-- > 0) {
			int[] now = cloudQueue.poll();
			int nowR = now[0];
			int nowC = now[1];
			
			map[nowR][nowC]++;
			
			rainedQueue.offer(new int[] {nowR, nowC});
			cloudQueue.offer(now);
		}
	}
	
	// 물복사버그
	static void waterCopyBug() {
		
		while(!rainedQueue.isEmpty()) {
			int[] now = rainedQueue.poll();
			int nowR = now[0];
			int nowC = now[1];
			
			int count = 0;
			
			for(int i=0; i<4; i++) {
				int nextR = nowR + dr[i];
				int nextC = nowC + dc[i];
				
				if(nextR < 1) continue;
				if(nextC < 1) continue;
				if(nextR > N) continue;
				if(nextC > N) continue;
				
				if(map[nextR][nextC] > 0) count++;
			}
			
			map[nowR][nowC] += count;
		}
	}
	
	// 물의 양의 합
	static int waterSum() {
		int sum = 0;
		
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=N; c++) {
				if(map[r][c]>0) {
					sum += map[r][c];
				}
			}
		}
		
		return sum;
	}
	
}
