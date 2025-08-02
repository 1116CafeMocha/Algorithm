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
		long answerLeft = Long.MAX_VALUE;
		long answerRight = Long.MAX_VALUE;
		int left = 0;
		int right = N - 1;

		while (true) {
			if (left >= right) {
				break;
			}
			long sum = arr[left] + arr[right];
			if (Math.abs(sum) < Math.abs(answer)) {
				answer = sum;
				answerLeft = arr[left];
				answerRight = arr[right];
			}

			if (sum == 0) {
				answerLeft = arr[left];
				answerRight = arr[right];
				break;
			} else if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}

		bw.write(answerLeft + " " + answerRight);

		bw.flush();
		bw.close();
	}
}
