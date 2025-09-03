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
		int MAX = 0;
		int d = 1000000;

		int[] arr = new int[10];

		if (N == 0) {
			arr[0] = 1;
		} else {
			while (N > 0) {
				arr[N % 10]++;
				N /= 10;
			}
		}

		for (int i = 0; i < 10; i++) {
			if (i == 6 || i == 9) {
				continue;
			}

			MAX = Math.max(MAX, arr[i]);
		}

		bw.write(Integer.toString(Math.max(MAX, (arr[6] + arr[9] + 1) / 2)));

		bw.flush();
		bw.close();
	}
}
