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

		int count = 0;
		boolean[] check = new boolean[150];

		process: for (int i = 0; i < N; i++) {
			String str = br.readLine();
			char now = '0';

			Arrays.fill(check, false);

			for (int k = 0; k < str.length(); k++) {
				if (now == str.charAt(k))
					continue;

				now = str.charAt(k);

				if (check[(int) now])
					continue process;

				check[(int) now] = true;
			}
			count++;
		}

		bw.write(count + "");

		bw.flush();
		bw.close();
	}
}