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
		String[][] arr = new String[5][15];

		for (int r = 0; r < 5; r++) {
			input = br.readLine().split("");
			for (int c = 0; c < input.length; c++) {
				arr[r][c] = input[c];
			}
		}

		for (int c = 0; c < 15; c++) {
			for (int r = 0; r < 5; r++) {
				if (arr[r][c] != null) {
					bw.write(arr[r][c]);
				}
			}
		}

		bw.flush();
		bw.close();
	}
}