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
		int H = Integer.parseInt(input[1]);
		int W = Integer.parseInt(input[2]);

		char[] answer = new char[N];
		Arrays.fill(answer, '?');

		for (int i = 0; i < H; i++) {
			char[] arr = br.readLine().toCharArray();

			for (int j = 0; j < N * W; j += W) {
				for (int k = 0; k < W; k++) {
					if (arr[j + k] != '?')
						answer[j / W] = arr[j + k];
				}

			}
		}

		for (char now : answer)
			bw.write(now);

		bw.flush();
		bw.close();
	}

}
