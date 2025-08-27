import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int C = Integer.parseInt(br.readLine());

		while (C-- > 0) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);

			int[] score = new int[N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				score[i] = Integer.parseInt(input[i + 1]);
				sum += score[i];
			}
			float P = (float) sum / N;
			int count = 0;
			for (int now : score) {
				if (now > P)
					count++;
			}
			double percent = count * 100.0 / N;
			bw.write(String.format("%.3f%%\n", percent));
		}

		bw.flush();
		bw.close();
	}
}
