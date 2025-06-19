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
		int result = 0;

		int[] count = new int[6];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < 6; i++) {
			count[i] = Integer.parseInt(input[i]);
		}

		input = br.readLine().split(" ");
		int T = Integer.parseInt(input[0]);
		int P = Integer.parseInt(input[1]);

		for (int i = 0; i < 6; i++) {
			int now = count[i];
			if (now == 0)
				continue;
			else if (now % T == 0)
				result += now / T;
			else
				result += now / T + 1;
		}

		bw.write(result + "\n");
		bw.write(N / P + " " + N % P);

		bw.flush();
		bw.close();
	}

}
