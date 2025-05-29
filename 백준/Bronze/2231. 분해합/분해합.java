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
		int min = Integer.MAX_VALUE;

		for (int i = N - 9 * Integer.toString(N).length(); i < N; i++) {
			char[] arr = Integer.toString(i).toCharArray();
			int sum = i;
			for (char now : arr) {
				sum += now - '0';
				if (sum > N)
					break;
			}

			if (sum == N)
				min = Math.min(i, min);
		}

		if (min == Integer.MAX_VALUE)
			bw.write("0");
		else
			bw.write(Integer.toString(min));

		bw.flush();
		bw.close();
	}
}
