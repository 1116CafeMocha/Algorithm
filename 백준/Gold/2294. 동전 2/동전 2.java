// 백준 2294번. 동전2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		TreeSet<Integer> set = new TreeSet<>();

		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(br.readLine()));
		}

		int[] dp = new int[K + 1];
		for (int coin : set) {
			if (coin > K)
				continue;
			dp[coin] = 1;
		}

		for (int i = 0; i <= K; i++) {
			for (int coin : set) {

				if (i - coin < 0)
					continue;

				if (dp[i - coin] == 0 && i - coin != 0)
					continue;

				if (dp[i] == 0) {
					dp[i] = dp[i - coin] + 1;
				}

				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}

		System.out.println(dp[K] == 0 ? -1 : dp[K]);
	}
}
