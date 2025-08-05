import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private static int fibonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		int a = 0, b = 1, result = 0;

		for (int i = 2; i <= n; i++) {
			result = a + b;
			a = b;
			b = result;
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		bw.write(Integer.toString(fibonacci(N)));

		bw.flush();
		bw.close();
	}
}
