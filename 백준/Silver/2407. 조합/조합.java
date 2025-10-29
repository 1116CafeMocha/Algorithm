import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		if (N == M) {
			System.out.println("1");
			return;
		}

		M = Math.min(M, N - M);

		BigInteger[] dp = new BigInteger[M + 1];

		for (int i = 0; i <= M; i++) {
			dp[i] = BigInteger.ZERO;
		}

		dp[0] = BigInteger.ONE;

		for (int i = 1; i <= N; i++) {
			int temp = Math.min(i, M);

			for (int j = temp; j >= 1; j--) {
				dp[j] = dp[j].add(dp[j - 1]);
			}
		}

		bw.write(dp[M].toString());

		bw.flush();
		bw.close();
	}

}
