import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		int[] prev = new int[N + 1];
		int[] dp = new int[N + 1];

		Arrays.fill(prev, 1);

		for (int i = 2; i <= K; i++) {
			dp[0] = 1;
			for (int j = 1; j <= N; j++) {
				dp[j] = dp[j - 1] + prev[j];
				if (dp[j] >= 1000000000) {
					dp[j] %= 1000000000;
				}
			}
			int[] temp = prev;
			prev = dp;
			dp = temp;
		}

		bw.write(Integer.toString(prev[N] % 1000000000));

		bw.flush();
		bw.close();
	}
}
