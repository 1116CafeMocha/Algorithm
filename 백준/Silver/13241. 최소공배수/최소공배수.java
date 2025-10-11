import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static long cal(long A, long B) {
		while (B != 0) {
			long val = A % B;
			A = B;
			B = val;
		}
		return A;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		long A = Long.parseLong(input[0]);
		long B = Long.parseLong(input[1]);

		long answer = (A / cal(A, B)) * B;

		bw.write(Long.toString(answer));

		bw.flush();
		bw.close();
	}
}
