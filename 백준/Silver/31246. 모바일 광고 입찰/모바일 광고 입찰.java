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
		int K = Integer.parseInt(input[1]);
		int X = 0;

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			arr[i] = Integer.parseInt(input[1]) - Integer.parseInt(input[0]);
		}

		Arrays.sort(arr);

		if (arr[K-1] > 0) {
			X = arr[K - 1];
		}

		bw.write(Integer.toString(X));

		bw.flush();
		bw.close();
	}

}
