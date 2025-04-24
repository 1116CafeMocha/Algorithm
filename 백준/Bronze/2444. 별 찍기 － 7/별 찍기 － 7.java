import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i < N; i++) {
			for (int k = 0; k < N - i; k++) {
				bw.write(" ");
			}
			for (int k = 0; k < (i - 1) * 2 + 1; k++) {
				bw.write("*");
			}
			bw.write("\n");
		}

		for (int i = 0; i < 2 * (N - 1) + 1; i++) {
			bw.write("*");
		}

		bw.write("\n");

		for (int i = 1; i < N; i++) {
			for (int k = 0; k < i; k++) {
				bw.write(" ");
			}
			for (int k = 0; k < (N - i) * 2 - 1; k++) {
				bw.write("*");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}