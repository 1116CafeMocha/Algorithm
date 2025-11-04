import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		String str = br.readLine();

		StringTokenizer st = new StringTokenizer(str);

		int[] arr = new int[N];

		int sum = 0;
		int MAX = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			if (i >= K) {
				sum -= arr[i - K];
			}

			if (i >= K - 1)
				MAX = Math.max(MAX, sum);
		}

		bw.write(Integer.toString(MAX));

		bw.flush();
		bw.close();
	}

}
