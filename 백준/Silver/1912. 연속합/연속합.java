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

		String[] input = br.readLine().split(" ");

		int[] dp = new int[N];

		dp[0] = Integer.parseInt(input[0]);

		int MAX = dp[0];

		for (int i = 1; i < N; i++) {
			int now = Integer.parseInt(input[i]);

			if (dp[i - 1] < 0) {
				dp[i] = now;
			} else {
				dp[i] = dp[i - 1] + now;
			}

			MAX = Math.max(MAX, dp[i]);
		}

		bw.write(Integer.toString(MAX));

		bw.flush();
		bw.close();
	}
}
