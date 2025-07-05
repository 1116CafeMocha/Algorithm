import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int R, C;
	static int count = 1;
	static boolean[][] map;
	static boolean[][] visited;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static Queue<int[]> man;
	static Queue<int[]> fire;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);

		map = new boolean[R][C];
		visited = new boolean[R][C];

		man = new LinkedList<>();
		fire = new LinkedList<>();

		for (int r = 0; r < R; r++) {
			char[] arr = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				char temp = arr[c];
				if (temp == '.') {
					map[r][c] = true;
				} else if (temp == 'J') {
					man.add(new int[] { r, c });
					visited[r][c] = true;
				} else if (temp == 'F') {
					fire.add(new int[] { r, c });
				}
			}
		}

		while (!man.isEmpty()) {
			int manSize = man.size();
			int fireSize = fire.size();
			int[] now;
			int nowR, nowC;

			for (int i = 0; i < fireSize; i++) {
				now = fire.poll();
				nowR = now[0];
				nowC = now[1];
				for (int j = 0; j < 4; j++) {
					int nextR = nowR + dr[j];
					int nextC = nowC + dc[j];

					if (nextR < 0)
						continue;
					if (nextC < 0)
						continue;
					if (nextR >= R)
						continue;
					if (nextC >= C)
						continue;
					if (!map[nextR][nextC])
						continue;

					map[nextR][nextC] = false;
					fire.add(new int[] { nextR, nextC });
				}
			}

			for (int i = 0; i < manSize; i++) {
				now = man.poll();
				nowR = now[0];
				nowC = now[1];

				if (nowR == 0 || nowR == R - 1 || nowC == 0 || nowC == C - 1) {
					bw.write(Integer.toString(count));
					bw.flush();
					bw.close();
					return;
				}

				for (int j = 0; j < 4; j++) {
					int nextR = nowR + dr[j];
					int nextC = nowC + dc[j];

					if (nextR < 0)
						continue;
					if (nextC < 0)
						continue;
					if (nextR >= R)
						continue;
					if (nextC >= C)
						continue;
					if (!map[nextR][nextC])
						continue;
					if (visited[nextR][nextC])
						continue;

					visited[nextR][nextC] = true;
					man.add(new int[] { nextR, nextC });
				}
			}

			count++;
		}

		bw.write("IMPOSSIBLE");

		bw.flush();
		bw.close();
	}
}
