import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 백준 7568번. 덩치

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;

		int N = Integer.parseInt(br.readLine());

		int[] height = new int[N];
		int[] weight = new int[N];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			height[i] = Integer.parseInt(input[0]);
			weight[i] = Integer.parseInt(input[1]);
		}

		for (int i = 0; i < N; i++) {
			int nowHeight = height[i];
			int nowWeight = weight[i];
			int count = 1;
			int idx = i;

			for (int k = 0; k < N; k++) {
				if (k == idx)
					continue;
				if (height[k] > nowHeight && weight[k] > nowWeight)
					count++;
			}

			bw.write(count + " ");
		}

		bw.flush();
		bw.close();
	}

}
