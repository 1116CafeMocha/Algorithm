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
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		int[] arr = new int[N];

		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int start = 0;
		int end = 0;
		int sum = 0;
		int count = 0;

		while (true) {
			if (sum >= M) {
				sum -= arr[start++];
			} else if (end == N) {
				break;
			} else {
				sum += arr[end++];
			}

			if (sum == M) {
				count++;
			}
		}

		bw.write(Integer.toString(count));

		bw.flush();
		bw.close();
	}
}
