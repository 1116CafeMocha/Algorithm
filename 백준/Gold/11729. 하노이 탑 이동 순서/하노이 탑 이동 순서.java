import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedWriter bw;

	static void hanoi(int n, int from, int to, int aux) throws IOException {
		if (n == 0)
			return;

		hanoi(n - 1, from, aux, to);
		bw.write(from + " " + to + "\n");
		hanoi(n - 1, aux, to, from);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		long moves = (1L << N) - 1;
		bw.write(moves + "\n");

		hanoi(N, 1, 3, 2);

		bw.flush();
		bw.close();
	}
}
