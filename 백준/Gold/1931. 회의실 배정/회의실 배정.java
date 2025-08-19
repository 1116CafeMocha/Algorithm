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

		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);

			arr[i][0] = start;
			arr[i][1] = end;
		}

		Arrays.sort(arr, (a, b) -> {
			if (a[1] != b[1])
				return Integer.compare(a[1], b[1]);
			return Integer.compare(a[0], b[0]);
		});

		int count = 0;
		int lastEnd = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i][0] >= lastEnd) {
				count++;
				lastEnd = arr[i][1];
			}
		}

		bw.write(Integer.toString(count));

		bw.flush();
		bw.close();
	}
}
