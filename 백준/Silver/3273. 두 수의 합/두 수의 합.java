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
		int X = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(arr);

		int left = 0;
		int right = N - 1;
		int count = 0;

		while (true) {
			if (left >= right) {
				break;
			}

			int sum = arr[left] + arr[right];

			if (sum > X) {
				right--;
			} else if (sum < X) {
				left++;
			} else {
				count++;
				left++;
				right--;
			}
		}

		bw.write(Integer.toString(count));

		bw.flush();
		bw.close();
	}
}
