// 백준 14503번. 로봇 청소기


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N, M, state, count;
	static boolean work;
	static int[] now;
	static boolean[][] map, cleaned;
	// 0: 북, 1: 동, 2: 남, 3: 서
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		map = new boolean[N][M];
		cleaned = new boolean[N][M];
		work = true;
		count = 0;
		
		input = br.readLine().split(" ");
		now = new int[] {Integer.parseInt(input[0]), Integer.parseInt(input[1])};
		state = Integer.parseInt(input[2]);
		
		for(int r=0; r<N; r++) {
			input = br.readLine().split(" ");
			for(int c=0; c<M; c++) {
				if(input[c].equals("1")) map[r][c] = true;
			}
		}
		
		// 작동 시작
		while(work) {
			// 현재 칸이 청소되지 않은 경우, 현재 칸 청소
			if(!cleaned[now[0]][now[1]]) {
				clean();
			}
			
			if(find()) {
				rotate();
				if(checkGo()) {
					go();
				}
			}else {
				if(checkBack()) {
					back();
				}else {
					work = false;
				}
			}
		}
		
		bw.write(Integer.toString(count));

		bw.flush();
		bw.close();
	}
	
	// 90도 회전
	static void rotate() {
		if(state == 0) state = 3;
		else state--;
		return;
	}
	
	// 현재 칸 청소
	static void clean() {
		cleaned[now[0]][now[1]] = true;
		count++;
		return;
	}
	
	// 청소되지 않은 칸 존재 여부 확인
	// 주변 4칸 중 청소되지 않은 빈 칸이 없다면 false, 있다면 true 리턴
	static boolean find() {
		int nowR = now[0];
		int nowC = now[1];
		
		for(int i=0; i<4; i++) {
			int nextR = nowR + dr[i];
			int nextC = nowC + dc[i];
			
			if(nextR < 0) continue;
			if(nextC < 0) continue;
			if(nextR >= N) continue;
			if(nextC >= M) continue;
			if(map[nextR][nextC]) continue;
			
			if(!cleaned[nextR][nextC]) return true;
		}
		return false;
	}
	
	// 전진 가능한지 확인
	// 가능하면 true, 불가능하다면 false 리턴
	static boolean checkGo() {
		int nextR = now[0] + dr[state];
		int nextC = now[1] + dc[state];
		
		if(map[nextR][nextC]) return false;
		if(nextR < 0) return false;
		if(nextC < 0) return false;
		if(nextR >= N) return false;
		if(nextC >= M) return false;
		
		// 앞 칸이 청소되지 않은 칸일 때만 전진 가능
		if(cleaned[nextR][nextC]) return false;
		
		return true;
	}
	
	// 후진 가능한지 확인
	// 가능하면 true, 불가능하다면 false 리턴
	static boolean checkBack() {
		int nextR = now[0] -(dr[state]);
		int nextC = now[1] -(dc[state]);
		
		if(map[nextR][nextC]) return false;
		if(nextR < 0) return false;
		if(nextC < 0) return false;
		if(nextR >= N) return false;
		if(nextC >= M) return false;
		
		return true;
	}
	
	// 전진
	static void go() {
		now[0] += dr[state];
		now[1] += dc[state];
	}
	
	// 후진
	static void back() {
		now[0] -= dr[state];
		now[1] -= dc[state];
	}
}
