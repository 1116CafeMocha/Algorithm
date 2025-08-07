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
		int E = Integer.parseInt(input[0]);
		int S = Integer.parseInt(input[1]);
		int M = Integer.parseInt(input[2]);

		int year = 1;

		while (true) {
			int e = (year - 1) % 15 + 1;
			int s = (year - 1) % 28 + 1;
			int m = (year - 1) % 19 + 1;

			if (e == E && s == S && m == M) {
				break;
			}
			year++;
		}

		bw.write(String.valueOf(year));

		bw.flush();
		bw.close();
	}
}
