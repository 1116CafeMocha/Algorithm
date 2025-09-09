import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] left = new int[N + 1];
		int[] right = new int[N + 1];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			left[a] = Integer.parseInt(input[1]);
			right[a] = Integer.parseInt(input[2]);
		}

		int depth = 0;
		int now = 1;

		while (right[now] != -1) {
			now = right[now];
			depth++;
		}

		long answer = 2L * (N - 1) - depth;
		bw.write(Long.toString(answer));

		bw.flush();
		bw.close();
	}
}
