// 백준 14501번. 퇴사

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		int answer = 0;

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 2];
		int[] T = new int[N + 1];
		int[] P = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			T[i] = Integer.parseInt(input[0]);
			P[i] = Integer.parseInt(input[1]);
		}

		for (int i = N; i >= 1; i--) {
			if (i + T[i] > N + 1) {
				dp[i] = dp[i + 1];
			} else {
				dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
				if (dp[i] > answer)
					answer = dp[i];
			}
		}
		System.out.println(answer);
	}

}
