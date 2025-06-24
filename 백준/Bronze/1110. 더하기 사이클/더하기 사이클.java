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
		int now = N;
		int count = 0;

		do {
			count++;
			int left = now / 10;
			int right = now % 10;
			int sum = left + right;
			now = right * 10 + (sum % 10);
		} while (now != N);

		bw.write(Integer.toString(count));

		bw.flush();
		bw.close();
	}

}
