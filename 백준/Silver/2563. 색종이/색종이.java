import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;
		int N = Integer.parseInt(br.readLine());
		boolean[][] paper = new boolean[100][100];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			int R = 100 - (Integer.parseInt(input[1]) + 10);
			int C = Integer.parseInt(input[0]);

			for (int r = R; r < R + 10; r++) {
				for (int c = C; c < C + 10; c++) {
					if (r < 0)
						continue;
					if (c < 0)
						continue;
					if (r >= 100)
						continue;
					if (c >= 100)
						continue;
					if (paper[r][c])
						continue;

					paper[r][c] = true;
				}
			}
		}

		int count = 0;

		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				if (paper[r][c])
					count++;
			}
		}

		bw.write(Integer.toString(count));

		bw.flush();
		bw.close();
	}
}