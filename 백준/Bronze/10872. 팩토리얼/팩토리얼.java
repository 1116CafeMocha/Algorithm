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

		int answer = N;

		for (int i = 1; i < N; i++) {
			answer *= i;
		}

		if (N == 0)
			answer = 1;

		bw.write(Integer.toString(answer));

		bw.flush();
		bw.close();
	}
}
