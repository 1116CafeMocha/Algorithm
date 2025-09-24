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
		int J = Integer.parseInt(br.readLine());

		int L = 1;
		int R = M;
		int move = 0;

		for (int i = 0; i < J; i++) {
			int now = Integer.parseInt(br.readLine());

			if (now < L) {
				int d = L - now;
				move += d;
				L -= d;
				R -= d;
			} else if (now > R) {
				int d = now - R;
				move += d;
				L += d;
				R += d;
			}
		}

		bw.write(Integer.toString(move));

		bw.flush();
		bw.close();
	}

}
