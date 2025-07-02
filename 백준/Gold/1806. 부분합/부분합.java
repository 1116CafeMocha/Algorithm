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
		int S = Integer.parseInt(input[1]);

		int min = Integer.MAX_VALUE, sum = 0, start = 0;

		input = br.readLine().split(" ");

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		for (int end = 0; end < N; end++) {
			sum += arr[end];

			while (sum >= S) {
				min = Math.min(min, end - start + 1);
				sum -= arr[start++];
			}
		}

		bw.write(Integer.toString(min == Integer.MAX_VALUE ? 0 : min));

		bw.flush();
		bw.close();
	}

}
