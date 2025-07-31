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

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		long M = Long.parseLong(input[1]);

		long[] arr = new long[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		Arrays.sort(arr);

		long answer = Long.MAX_VALUE;
		int left = 0;
		int right = 0;

		while (right < N) {
			long sub = arr[right] - arr[left];

			if (sub == M) {
				answer = M;
				break;
			} else if (sub < M) {
				right++;
			} else {
				left++;
				answer = Math.min(answer, sub);
			}
		}

		bw.write(Long.toString(answer));

		bw.flush();
		bw.close();
	}
}
