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
		int M = Integer.parseInt(input[1]);

		int[] basket = new int[N + 1];

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int I = Integer.parseInt(input[0]);
			int J = Integer.parseInt(input[1]);
			int K = Integer.parseInt(input[2]);

			for (int k = I; k <= J; k++) {
				basket[k] = K;
			}
		}

		for (int i = 1; i <= N; i++) {
			bw.write(basket[i] + " ");
		}

		bw.flush();
		bw.close();
	}
}
