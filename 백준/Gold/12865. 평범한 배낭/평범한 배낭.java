import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 12865번. 평범한 배낭

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		int[] W = new int[N + 1];
		int[] V = new int[N + 1];
		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			W[i] = Integer.parseInt(input[0]);
			V[i] = Integer.parseInt(input[1]);
		}

		for (int i = 1; i <= N; i++) {
			for (int w = 0; w <= K; w++) {
				if (W[i] > w) {
					dp[i][w] = dp[i - 1][w];
				} else {
					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - W[i]] + V[i]);
				}
			}
		}

		System.out.println(dp[N][K]);

	}

}
