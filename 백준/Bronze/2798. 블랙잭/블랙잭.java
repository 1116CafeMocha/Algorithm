import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int max = 0;

		int[] cards = new int[N];

		input = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(input[i]);
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					int sum = cards[i] + cards[j] + cards[k];
					if (sum > M)
						continue;
					max = Math.max(max, sum);
				}
			}
		}

		bw.write(Integer.toString(max));

		bw.flush();
		bw.close();
	}
}
