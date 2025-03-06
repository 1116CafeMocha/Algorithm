import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 백준 1003번. 피보나치 함수

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] dp0 = new int[40 + 1];
		int[] dp1 = new int[40 + 1];

		dp0[0] = 1;
		dp1[0] = 0;
		dp0[1] = 0;
		dp1[1] = 1;

		for (int i = 2; i <= 40; i++) {
			dp0[i] = dp0[i - 1] + dp0[i - 2];
			dp1[i] = dp1[i - 1] + dp1[i - 2];
		}

		int T = Integer.parseInt(br.readLine());
		for (int testcase = 0; testcase < T; testcase++) {
			int N = Integer.parseInt(br.readLine());

			bw.write(dp0[N] + " " + dp1[N] + "\n");
		}

		bw.flush();
		bw.close();
	}

}
