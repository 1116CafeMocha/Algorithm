import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long N = Long.parseLong(br.readLine());
		long answer = 0;

		while (N > 1) {
			if (N % 2 == 0) {
				N /= 2;
			} else {
				N++;
			}
			answer++;
		}

		bw.write(Long.toString(answer));

		bw.flush();
		bw.close();
	}
}
