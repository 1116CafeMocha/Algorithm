import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static final int MOD = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		long[][] dp = new long[N + 1][10];

		dp[1][0] = 0;

		// 길이 1
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}

		// 길이 2~N
		for (int i = 2; i <= N; i++) {
			// 마지막 숫자가 0인 경우, 이전은 1만 가능
			dp[i][0] = dp[i - 1][1] % MOD;

			// 마지막 숫자가 1~8인 경우
			for (int j = 1; j <= 8; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
			}

			// 마지막 숫자가 9인 경우, 이전은 8만 가능
			dp[i][9] = dp[i - 1][8] % MOD;
		}

		long answer = 0;

		for (int i = 0; i <= 9; i++) {
			answer = (answer + dp[N][i]) % MOD;
		}

		bw.write(Long.toString(answer));

		bw.flush();
		bw.close();
	}

}
