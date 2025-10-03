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
		int val = (int) Math.sqrt(N);

		if (Math.pow(val, 2) == N) {
			bw.write(Integer.toString(1));
		} else {
			int[] arr = new int[val + 1];
			for (int i = 1; i <= val; i++) {
				arr[i] = (int) Math.pow(i, 2);
			}

			for (int i = 1; i <= N; i++) {
				dp[i] = i;
			}

			for (int i = 1; i <= N; i++) {
				for (int j=1; j<=val; j++) {
					int now = arr[j];
					
					if (now > i)
						break;

					dp[i] = Math.min(dp[i], dp[i - now] + 1);
				}
			}

			bw.write(Integer.toString(dp[N]));
		}

		bw.flush();
		bw.close();
	}

}
