// 백준 9084번. 동전

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;
		int N, M;
		int[] coin, dp;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < T; testCase++) {
			N = Integer.parseInt(br.readLine());
			input = br.readLine().split(" ");
			coin = new int[N];

			for (int i = 0; i < N; i++) {
				coin[i] = Integer.parseInt(input[i]);
			}

			M = Integer.parseInt(br.readLine());

			dp = new int[M + 1];

			dp[0] = 1;

			for (int i = 0; i < N; i++) {
				for (int j = coin[i]; j <= M; j++) {
					dp[j] += dp[j - coin[i]];
				}
			}

			bw.write(Integer.toString(dp[M]) + "\n");
		}

		bw.flush();
		bw.close();
	}
}
