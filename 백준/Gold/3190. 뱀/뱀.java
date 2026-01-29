import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N, K, snakeDir, time;
	static boolean[][] map;
	static boolean[][] visiting;
	static Map<Integer, Character> dirMap;
	static Deque<int[]> snake;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		visiting = new boolean[N][N];
		snake = new ArrayDeque<>();
		snakeDir = 0;
		time = 1;
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			map[R-1][C-1] = true;
		}
		
		int L = Integer.parseInt(br.readLine());
		dirMap = new HashMap<>();
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			dirMap.put(X, C);
		}
		
		snake.addFirst(new int[] {0, 0});
		visiting[0][0] = true;
		
		while(true) {
			// 현재 위치
			int nowR = snake.peekFirst()[0];
			int nowC = snake.peekFirst()[1];
			
			// 다음 칸 위치 확인
			int nextR = nowR + dr[snakeDir];
			int nextC = nowC + dc[snakeDir];
			
			// 벽이나 자기 자신의 몸과 부딪히면 게임이 끝난다.
			if(nextR < 0) break;
			if(nextC < 0) break;
			if(nextR >= N) break;
			if(nextC >= N) break;
			if(visiting[nextR][nextC]) break;
			
			// 몸 길이를 늘려 머리를 다음 칸에 위치시킨다.
			snake.addFirst(new int[] {nextR, nextC});
			visiting[nextR][nextC] = true;
			
			// 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
			if(map[nextR][nextC]) map[nextR][nextC] = false;
			// 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
			else {
				int tailR = snake.peekLast()[0];
				int tailC = snake.peekLast()[1];
				visiting[tailR][tailC] = false;
				snake.pollLast();
			}
			
			// 방향 전환
			if(dirMap.containsKey(time)) turn(dirMap.get(time));
			
			time++;
		}
		
		bw.write(Integer.toString(time));
		
		bw.flush();
		bw.close();
	}
	
	static void turn (char c) {
		if(c == 'D') snakeDir++;
		else snakeDir--;
		
		if(snakeDir < 0) snakeDir += 4;
		else if(snakeDir > 3) snakeDir %= 4;
	}
}
