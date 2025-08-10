import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			char[] input = br.readLine().toCharArray();
			if (!Character.isUpperCase(input[0])) {
				input[0] = Character.toUpperCase(input[0]);
			}

			for (char now : input) {
				bw.write(now);
			}

			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}
