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
		int M = Integer.parseInt(input[1]);

		int[] arr = new int[N + M];

		input = br.readLine().split(" ");
		int idx = 0;
		for (int i = 0; i < N; i++) {
			arr[idx++] = Integer.parseInt(input[i]);
		}
		input = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			arr[idx++] = Integer.parseInt(input[i]);
		}

		Arrays.sort(arr);
		for (int now : arr) {
			bw.write(Integer.toString(now) + " ");
		}

		bw.flush();
		bw.close();
	}
}
