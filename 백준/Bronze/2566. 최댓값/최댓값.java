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
		int max = -1;
		int[] maxArr = new int[2];

		for (int r = 1; r <= 9; r++) {
			input = br.readLine().split(" ");
			for (int c = 1; c <= 9; c++) {
				int now = Integer.parseInt(input[c - 1]);
				if (now > max) {
					max = now;
					maxArr[0] = r;
					maxArr[1] = c;
				}
			}
		}

		bw.write(Integer.toString(max));
		bw.newLine();
		bw.write(maxArr[0] + " " + maxArr[1]);

		bw.flush();
		bw.close();
	}
}