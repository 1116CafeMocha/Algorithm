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

		for (int i = 0; i < N; i++) {
			String[] arr = Integer.toString(i).split("");
			int sum = i;
			for (String now : arr) {
				sum += Integer.parseInt(now);
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
