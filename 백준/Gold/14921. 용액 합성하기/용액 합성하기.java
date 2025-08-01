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
		String[] input = br.readLine().split(" ");

		long[] arr = new long[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(input[i]);
		}

		Arrays.sort(arr);

		long answer = Long.MAX_VALUE;
		int left = 0;
		int right = N - 1;

		while (true) {
			if (left >= right) {
				break;
			}
			long sum = arr[left] + arr[right];
			long sumAbs = Math.abs(sum);
			answer = Math.min(Math.abs(answer), sumAbs) == sumAbs ? sum : answer;

			if (sum == 0) {
				answer = 0;
				break;
			} else if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}

		bw.write(Long.toString(answer));

		bw.flush();
		bw.close();
	}
}
