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

		long[] dp = new long[N + 1];

		// 빈 상태
		dp[0] = 1;

		// 2칸을 깔끔하게 채울 수 있는 세 가지 방법
		if (N >= 2) {
			dp[2] = 3;
		}

		// 홀수는 채울 수 없으므로 짝수만!!
		for (int i = 4; i <= N; i += 2) {
			long sum = 0;

			for (int j = i - 4; j >= 0; j -= 2) {
				sum += dp[j];
			}

			dp[i] = dp[i - 2] * 3 + sum * 2;
		}

		bw.write(Long.toString(dp[N]));

		bw.flush();
		bw.close();
	}
}
