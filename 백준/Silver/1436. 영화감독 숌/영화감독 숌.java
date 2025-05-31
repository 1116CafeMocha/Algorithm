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

		int num = 666;
		int count = 0;

		while (count < N) {
			String str = Integer.toString(num);
			if (str.contains("666")) {
				count++;

				if (count == N)
					break;

			}

			num++;
		}

		bw.write(Integer.toString(num));

		bw.flush();
		bw.close();
	}
}
