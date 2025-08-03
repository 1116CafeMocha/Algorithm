import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			long K = Long.parseLong(input[1]);

			long[] arr = new long[N];

			input = br.readLine().split(" ");

			for (int i = 0; i < N; i++) {
				arr[i] = Long.parseLong(input[i]);
			}

			Arrays.sort(arr);

			long answer = Long.MAX_VALUE;
			int count = 0;
			int left = 0;
			int right = N - 1;

			while (true) {
				if (left >= right) {
					break;
				}
				long sum = arr[left] + arr[right];
				if (sum != answer && Math.abs(sum - K) < Math.abs(answer - K)) {
					answer = sum;
					count = 1;
				} else if (Math.abs(sum - K) == Math.abs(answer - K)) {
					count++;
				}

				if (sum <= K) {
					left++;
				} else {
					right--;
				}
			}

			bw.write(count + "\n");
		}

		bw.flush();
		bw.close();
	}
}
