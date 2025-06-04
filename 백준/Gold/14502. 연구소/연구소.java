// 백준 14502번. 연구소

// (3<=N, M<=8)
// 바이러스 시뮬레이션 : bfs
// 벽 무조건 3개 세워야 함. -> 모든 경우 확인
// 안전 영역 찾고 크기 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N, M, wallCount = 0, max = Integer.MIN_VALUE;
	static boolean[][] originalMap;
	static List<int[]> virus;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		originalMap = new boolean[N][M];
		virus = new ArrayList<>();

		for (int r = 0; r < N; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				// 벽이나 바이러스는 true, 빈 칸은 false
				if (!input[c].equals("0")) {
					originalMap[r][c] = true;
					if (input[c].equals("2")) {
						virus.add(new int[] { r, c });
					} else {
						wallCount++;
					}
				}
			}
		}
		wallCount += 3;

		makeWall(0, originalMap);

		System.out.println(max);
	}

	// 벽 세우기
	static void makeWall(int count, boolean[][] map) {
		if (count == 3) {
			max = Math.max(max, bfs(map));
			return;
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c])
					continue;
				map[r][c] = true;
				makeWall(count + 1, map);
				map[r][c] = false;
			}
		}

	}

	// BFS (바이러스 진행)
	static int bfs(boolean[][] map) {
		int count = 0;
		Queue<int[]> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		for (int[] now : virus) {
			visited[now[0]][now[1]] = true;
			que.add(new int[] { now[0], now[1] });
			count++;
		}

		while (!que.isEmpty()) {
			int sizeOfQue = que.size();

			for (int i = 0; i < sizeOfQue; i++) {
				int[] now = que.poll();

				for (int j = 0; j < 4; j++) {
					int nowR = now[0] + dr[j];
					int nowC = now[1] + dc[j];

					if (nowR < 0)
						continue;
					if (nowC < 0)
						continue;
					if (nowR >= N)
						continue;
					if (nowC >= M)
						continue;

					if (visited[nowR][nowC])
						continue;
					if (map[nowR][nowC])
						continue;

					visited[nowR][nowC] = true;
					count++;
					que.add(new int[] { nowR, nowC });
				}
			}
		}
		return N * M - count - wallCount;
	}
}
