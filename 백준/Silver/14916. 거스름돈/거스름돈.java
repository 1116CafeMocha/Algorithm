import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		final int INF = 1_000_000_000;

		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			dp[i] = INF;
		}

		for (int i = 2; i <= N; i++) {
			dp[i] = Math.min(dp[i], dp[i - 2] + 1);

			if (i >= 5) {
				dp[i] = Math.min(dp[i], dp[i - 5] + 1);
			}
		}

		if (dp[N] >= INF) {
			bw.write("-1");
		} else {
			bw.write(Integer.toString(dp[N]));
		}

		bw.flush();
		bw.close();
	}
}
