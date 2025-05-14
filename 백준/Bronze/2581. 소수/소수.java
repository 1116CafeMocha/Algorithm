import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		boolean[] sosu = new boolean[N + 1];

		sosu[0] = true;
		sosu[1] = true;

		for (int i = 2; i <= N; i++) {
			if (!sosu[i]) {
				for (int j = 2; j * i <= N; j++) {
					if (!sosu[i * j]) {
						sosu[i * j] = true;
					}
				}
			}
		}

		int sum = 0;
		int min = -1;

		for (int i = N; i >= M; i--) {
			if (!sosu[i]) {
				sum += i;
				min = i;
			}
		}

		if (sum != 0) {
			bw.write(Integer.toString(sum));
			bw.newLine();
		}
		bw.write(Integer.toString(min));

		bw.flush();
		bw.close();
	}
}