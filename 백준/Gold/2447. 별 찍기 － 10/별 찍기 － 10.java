import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(map[i], ' ');

		draw(0, 0, N);

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				bw.write(map[r][c]);
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}

	static void draw(int R, int C, int size) {
		if (size == 1) {
			map[R][C] = '*';
			return;
		}
		int next = size / 3;

		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (r == 1 && c == 1)
					continue;
				draw(R + r * next, C + c * next, next);
			}
		}
	}
}
