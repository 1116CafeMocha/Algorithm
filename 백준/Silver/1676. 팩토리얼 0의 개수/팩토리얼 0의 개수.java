import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int R, C;
	static String[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 5; i <= N; i *= 5) {
			count += N / i;
		}

		bw.write(Integer.toString(count));

		bw.flush();
		bw.close();
	}
}
