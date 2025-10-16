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
		int H = Integer.parseInt(input[0]);
		int W = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");

		int[] arr = new int[W];

		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int[] leftMax = new int[W];
		int[] rightMax = new int[W];

		leftMax[0] = arr[0];
		rightMax[W - 1] = arr[W - 1];

		for (int i = 1; i < W; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
		}

		for (int i = W - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
		}

		int sum = 0;

		for (int i = 1; i < W - 1; i++) {
			int val = Math.min(leftMax[i], rightMax[i]) - arr[i];

			if (val > 0) {
				sum += val;
			}
		}

		bw.write(Integer.toString(sum));

		bw.flush();
		bw.close();
	}
}
