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

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int now = Integer.parseInt(br.readLine());

			bw.write(now / 25 + " ");
			now %= 25;

			bw.write(now / 10 + " ");
			now %= 10;

			bw.write(now / 5 + " ");
			now %= 5;

			bw.write(now + "\n");
		}

		bw.flush();
		bw.close();
	}
}