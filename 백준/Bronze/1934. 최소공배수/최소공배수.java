import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;

		int T = Integer.parseInt(br.readLine());

		for (int testcase = 0; testcase < T; testcase++) {
			input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);

			List<Integer> list = new ArrayList<>();

			while (true) {
				boolean flag = false;
				for (int i = 2; i <= Math.min(A, B); i++) {
					if (A % i == 0 && B % i == 0) {
						list.add(i);
						A /= i;
						B /= i;
						flag = true;
						break;
					}
				}

				if (!flag || A <= 1 || B <= 1) {
					break;
				}
			}

			int result = 1;

			for (int i = 0; i < list.size(); i++) {
				result *= list.get(i);
			}
			result *= A * B;

			bw.write(Integer.toString(result));
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}
