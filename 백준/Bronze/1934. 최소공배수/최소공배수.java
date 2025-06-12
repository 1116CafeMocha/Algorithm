// 유클리드 호제법 사용
// B가 A보다 큰 경우에도 잘 작동함

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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

			int result = A * B;

			while (B != 0) {
				int temp = A % B;
				A = B;
				B = temp;
			}

			result /= A;
			bw.write(Integer.toString(result));
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}
