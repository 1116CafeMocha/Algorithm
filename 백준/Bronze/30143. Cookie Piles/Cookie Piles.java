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
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int A = Integer.parseInt(input[1]);
			int D = Integer.parseInt(input[2]);

			int answer = A;
			while (N-- > 1) {
				A += D;
				answer += A;
			}

			bw.write(Integer.toString(answer));
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}
