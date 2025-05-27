import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 1520번. 내리막 길

public class Main {
	static int M, N;
	static int[][] map, dp;

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);

		map = new int[M][N];
		dp = new int[M][N];

		for (int r = 0; r < M; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(input[c]);
				dp[r][c] = -1;
			}
		}

		dfs(0, 0);

		System.out.println(dp[0][0]);

	}

	static int dfs(int R, int C) {
		if (R == M - 1 && C == N - 1) {
			return 1;
		}

		if (dp[R][C] != -1) {
			return dp[R][C];
		}

		dp[R][C] = 0;

		for (int i = 0; i < 4; i++) {
			int nowR = R + dr[i];
			int nowC = C + dc[i];

			if (nowR >= M)
				continue;
			if (nowC >= N)
				continue;
			if (nowR < 0)
				continue;
			if (nowC < 0)
				continue;
			if (map[R][C] <= map[nowR][nowC])
				continue;

			dp[R][C] += dfs(nowR, nowC);
		}

		return dp[R][C];
	}
}
