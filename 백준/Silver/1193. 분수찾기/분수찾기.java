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

		int N = Integer.parseInt(br.readLine());

		int idx = 1;

		while ((idx * (idx + 1)) / 2 < N) {
			idx++;
		}

		int A, B;

		if (idx % 2 == 0) {
			A = N - (idx * (idx - 1)) / 2;
			B = (idx + 1) - A;
		} else {
			B = N - (idx * (idx - 1)) / 2;
			A = (idx + 1) - B;
		}

		bw.write(A + "/" + B);

		bw.flush();
		bw.close();
	}
}