import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		int cnt = 0;
		int ans = -1;

		for (int i = 1; i <= N; i++) {
			if (N % i == 0)
				cnt++;
			if (cnt == K) {
				ans = i;
				break;
			}
		}

		if (ans == -1) {
			bw.write("0");
		} else {
			bw.write(Integer.toString(ans));
		}

		bw.flush();
		bw.close();
	}
}