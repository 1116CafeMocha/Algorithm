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

		int[] dp = new int[N + 1];
		int[] prev = new int[N + 1];

		dp[1] = 0;

		for (int i = 2; i <= N; i++) {
			// i-1의 경우
			dp[i] = dp[i - 1] + 1;
			prev[i] = i - 1;

			// i/2의 경우
			if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
				dp[i] = dp[i / 2] + 1;
				prev[i] = i / 2;
			}

			// i/3의 경우
			if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
				dp[i] = dp[i / 3] + 1;
				prev[i] = i / 3;
			}
		}

		int now = N;

		bw.write(Integer.toString(dp[N]));
		bw.newLine();

		while (true) {
			bw.write(Integer.toString(now) + " ");
			if (now == 1)
				break;
			now = prev[now];
		}

		bw.flush();
		bw.close();
	}

}
