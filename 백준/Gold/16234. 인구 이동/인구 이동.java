/*
 * map[N][N]
 * 경계를 공유하는 두 칸
 * 값 차이가 L 이상, R 이하면 경계 오픈.
 * 맵 전체에서 해당되는 칸의 경계 전부 오픈.
 * 인구 이동 시작.
 * 경계 열려있으면 연합.
 * 연합의 각 칸 값은 (연합 전체 값) / (연합을 이룬 칸의 개수). 소수점 버림
 * 연합 해체, 경계 닫음.
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> que;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int L = Integer.parseInt(input[1]);
		int R = Integer.parseInt(input[2]);

		map = new int[N][N];
		visited = new boolean[N][N];
		que = new ArrayDeque<>();

		for (int r = 0; r < N; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(input[c]);
			}
		}

		int days = 0;

		Queue<int[]> area = new ArrayDeque<>();

		boolean flag = true;

		while (flag) {
			// 초기화
			flag = false;
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], false);
			}

			for (int r = 0; r < N; r++) {

				for (int c = 0; c < N; c++) {
					if (visited[r][c])
						continue;
					
					visited[r][c] = true;
					
					que.offer(new int[] { r, c });
					area.offer(new int[] { r, c });

					int sum = map[r][c];

					while (!que.isEmpty()) {
						int size = que.size();

						while (size-- > 0) {
							int[] now = que.poll();
							int nowR = now[0];
							int nowC = now[1];

							for (int i = 0; i < 4; i++) {
								int nextR = nowR + dr[i];
								int nextC = nowC + dc[i];

								if (nextR >= N)
									continue;
								if (nextC >= N)
									continue;
								if (nextR < 0)
									continue;
								if (nextC < 0)
									continue;

								if (visited[nextR][nextC])
									continue;

								int val = Math.abs(map[nowR][nowC] - map[nextR][nextC]);

								if (L <= val && val <= R) {
									visited[nextR][nextC] = true;
									flag = true;

									sum += map[nextR][nextC];
									que.offer(new int[] { nextR, nextC });
									area.offer(new int[] { nextR, nextC });
								}
							}
						}
					}

					int avg = sum / area.size();

					for (int[] now : area) {
						map[now[0]][now[1]] = avg;
					}

					area.clear();
				}
			}

			if (flag)
				days++;
		}

		bw.write(Integer.toString(days));

		bw.flush();
		bw.close();
	}

}
