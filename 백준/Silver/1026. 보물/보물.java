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

		int[] A = new int[N];
		int[] B = new int[N];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(input[i]);
		}

		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(input[i]);
		}

		int answer = 0;

		Arrays.sort(A);
		Arrays.sort(B);

		for (int i = 0; i < N; i++) {
			answer += A[i] * B[N - 1 - i];
		}

		bw.write(Integer.toString(answer));

		bw.flush();
		bw.close();
	}
}
