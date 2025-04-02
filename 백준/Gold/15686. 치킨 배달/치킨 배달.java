import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N, M;
	static int[][] map;
	static List<int[]> house;
	static List<int[]> chicken;
	static int result;
	static int[] comb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		map = new int[N][N];
		chicken = new ArrayList<>();
		house = new ArrayList<>();
		result = Integer.MAX_VALUE;
		comb = new int[M];

		for (int r = 0; r < N; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				int val = Integer.parseInt(input[c]);
				map[r][c] = val;
				if (val == 1) {
					house.add(new int[] { r, c });
				} else if (val == 2) {
					chicken.add(new int[] { r, c });
				}
			}
		}

		dfs(0, 0);

		System.out.println(result);

	}

	// 치킨집 조합 dfs
	static void dfs(int idx, int start) {
		if (idx == M) {
			calculate();
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			comb[idx] = i;
			dfs(idx + 1, i + 1);
		}
	}

	// 치킨 거리 계산
	static void calculate() {
		int total = 0;

		for (int[] nowHouse : house) {
			int dist = Integer.MAX_VALUE;

			for (int i = 0; i < M; i++) {
				int[] nowChicken = chicken.get(comb[i]);
				int d = Math.abs(nowHouse[0] - nowChicken[0]) + Math.abs(nowHouse[1] - nowChicken[1]);
				dist = Math.min(dist, d);
			}

			total += dist;
		}

		result = Math.min(result, total);
	}

}
