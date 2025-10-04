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

		String[] input = br.readLine().split(" ");

		int[] arr = new int[N + 1];

		arr[0] = 0;
		arr[1] = Integer.parseInt(input[0]);

		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(input[i - 1]);
		}

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);

			bw.write(Integer.toString(arr[B] - arr[A - 1]));
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}

}
