import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		long answer = 1;

		long[] arr = new long[B + 1];

		arr[0] = 0;

		for (int i = 1; i < B + 1; i++) {
			arr[i] = arr[i - 1] + i;
		}

		for (int i = A; i <= B; i++) {
			answer *= arr[i];
			answer %= 14579;
		}
		bw.write(Long.toString(answer));

		bw.flush();
		bw.close();
	}
}
