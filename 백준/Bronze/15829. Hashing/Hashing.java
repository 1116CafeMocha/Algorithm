import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int L = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();

		long val = 0L;
		long p = 1L;

		for (int i = 0; i < L; i++) {
			val = (val + ((input[i] - 'a' + 1) * p) % 1234567891) % 1234567891;
			p = (p * 31L) % 1234567891;
		}

		bw.write(Long.toString(val));

		bw.flush();
		bw.close();
	}

}
