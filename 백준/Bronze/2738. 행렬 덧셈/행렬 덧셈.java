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

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		int[][] arr = new int[N][M];

		for (int r = 0; r < N; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(input[c]);
			}
		}

		for (int r = 0; r < N; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				arr[r][c] += Integer.parseInt(input[c]);
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				bw.write(Integer.toString(arr[r][c]) + " ");
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}