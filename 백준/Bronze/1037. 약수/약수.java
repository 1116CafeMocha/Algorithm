import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int MAX = Integer.MIN_VALUE;
		int MIN = Integer.MAX_VALUE;

		int M = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		for (int i = 0; i < M; i++) {
			int now = Integer.parseInt(input[i]);

			MAX = Math.max(MAX, now);
			MIN = Math.min(MIN, now);
		}

		bw.write(Integer.toString(MAX * MIN));

		bw.flush();
		bw.close();
	}

}
