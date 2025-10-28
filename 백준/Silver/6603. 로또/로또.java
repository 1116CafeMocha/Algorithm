import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedWriter bw;
	static int K;
	static int[] arr;
	static boolean[] used;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			String[] input = br.readLine().split(" ");

			K = Integer.parseInt(input[0]);

			if (input.length == 1 && K == 0) {
				break;
			}

			arr = new int[K];
			used = new boolean[K];

			for (int i = 0; i < K; i++) {
				arr[i] = Integer.parseInt(input[i + 1]);
			}

			comb(0, 0, new int[6]);

			bw.newLine();
		}

		bw.flush();
		bw.close();
	}

	static void comb(int start, int idx, int[] answer) throws IOException {
		if (idx == 6) {
			for (int now : answer) {
				bw.write(now + " ");
			}
			bw.newLine();
			return;
		}

		for (int i = start; i < K; i++) {
			if (used[i])
				continue;

			if (idx != 0 && answer[idx - 1] > arr[i])
				continue;

			answer[idx] = arr[i];
			used[i] = true;
			comb(start + 1, idx + 1, answer);
			used[i] = false;
		}
	}

}
