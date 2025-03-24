import java.util.Scanner;

// 백준 11726번. 2xn 타일링
// dp[n] = dp[n-1] + dp[n-2] 점화식 찾아내야 한다!

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		if (n == 1) {
			System.out.println(1);
			return;
		}
		if (n == 2) {
			System.out.println(2);
			return;
		}

		int[] dp = new int[n + 1];

		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}

		System.out.println(dp[n]);

	}

}
