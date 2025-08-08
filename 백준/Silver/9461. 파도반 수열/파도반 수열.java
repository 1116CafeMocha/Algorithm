import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int[] nums = new int[T];
		int MAX = 0;

		for (int i = 0; i < T; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			MAX = Math.max(MAX, nums[i]);
		}

		long[] dp = new long[Math.max(6, MAX + 1)];

		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;

		for (int i = 6; i <= MAX; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}

		for (int now : nums) {
			bw.write(dp[now] + "\n");
		}

		bw.flush();
		bw.close();
	}
}
