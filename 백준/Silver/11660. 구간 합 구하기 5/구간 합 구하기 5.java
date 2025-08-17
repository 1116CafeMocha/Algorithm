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

		int[][] map = new int[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			input = br.readLine().split(" ");
			for (int c = 1; c <= N; c++) {
				map[r][c] = map[r - 1][c] + map[r][c - 1] - map[r - 1][c - 1] + Integer.parseInt(input[c - 1]);
			}
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int x1 = Integer.parseInt(input[0]);
			int y1 = Integer.parseInt(input[1]);
			int x2 = Integer.parseInt(input[2]);
			int y2 = Integer.parseInt(input[3]);

			bw.write(Integer.toString(map[x2][y2] - map[x1 - 1][y2] - map[x2][y1 - 1] + map[x1 - 1][y1 - 1]));
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}
