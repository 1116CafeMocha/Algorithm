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
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		int N = Integer.parseInt(input[2]);

		A %= B;

		for (int i = 1; i < N; i++) {
			A *= 10;
			A %= B;
		}

		A *= 10;

		int val = A / B;

		bw.write(Integer.toString(val));

		bw.flush();
		bw.close();
	}

}
