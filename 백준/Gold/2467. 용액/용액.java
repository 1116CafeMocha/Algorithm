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

		int left = 0;
		int right = N - 1;

		long MIN = Long.MAX_VALUE;
		long[] answer = { 0, 0 };

		while (left < right) {
			long sum = arr[left] + arr[right];
			long abs = Math.abs(sum);

			if (abs < MIN) {
				MIN = abs;
				answer[0] = arr[left];
				answer[1] = arr[right];
			}

			if (sum == 0)
				break;

			if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}

		bw.write(answer[0] + " " + answer[1]);

		bw.flush();
		bw.close();
	}
}
