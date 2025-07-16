import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N, K;
	static int[][] ingredient;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		ingredient = new int[N][2];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			ingredient[i][0] = Integer.parseInt(input[0]);
			ingredient[i][1] = Integer.parseInt(input[1]);
		}

		for (int bit = 1; bit < (1 << N); bit++) {
			int sour = 1;
			int bitter = 0;

			for (int i = 0; i < N; i++) {
				if ((bit & (1 << i)) != 0) {
					sour *= ingredient[i][0];
					bitter += ingredient[i][1];
				}
			}

			min = Math.min(min, Math.abs(sour - bitter));
		}
		bw.write(Integer.toString(min));

		bw.flush();
		bw.close();
	}
}
