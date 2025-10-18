import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		boolean[] arr = new boolean[N + 1];

		int count = 0;

		for (int i = 2; i <= N; i++) {
			if (arr[i])
				continue;

			int val = i;

			while (val <= N) {
				if (arr[val]) {
					val += i;
					continue;
				}

				arr[val] = true;
				count++;
				if (count == K) {
					System.out.println(val);
					return;
				}
				val += i;
			}
		}
	}
}
