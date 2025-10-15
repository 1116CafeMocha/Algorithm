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

		int N = Integer.parseInt(br.readLine());

		long[] arr = new long[N];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(input[i]);
		}

		Arrays.sort(arr);

		int count = 0;

		for (int i = 0; i < N; i++) {
			long target = arr[i];
			int left = 0;
			int right = N - 1;

			boolean OK = false;

			while (left < right) {
				if (left == i) {
					left++;
					continue;
				}
				if (right == i) {
					right--;
					continue;
				}
				long sum = arr[left] + arr[right];
				if (sum == target) {
					OK = true;
					break;
				}
				if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
			if (OK) {
				count++;
			}
		}

		bw.write(Integer.toString(count));

		bw.flush();
		bw.close();
	}
}
