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

		loop: while (count < N) {
			char[] str = Integer.toString(num).toCharArray();

			for (int i = 0; i < str.length - 2; i++) {
				if (str[i] == '6' && str[i + 1] == '6' && str[i + 2] == '6') {
					count++;

					if (count == N) {
						break loop;
					}
					break;
				}
			}
			num++;
		}

		bw.write(Integer.toString(num));

		bw.flush();
		bw.close();
	}
}
