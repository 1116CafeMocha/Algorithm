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

		while (true) {
			input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			int C = Integer.parseInt(input[2]);

			if (A + B + C == 0)
				break;

			int max = Math.max(Math.max(A, B), C);

			if (A + B + C - max > max) {
				if (A == B && B == C)
					bw.write("Equilateral\n");
				else if (A == B || B == C || A == C) {
					bw.write("Isosceles\n");
				} else {
					bw.write("Scalene\n");
				}
			} else {
				bw.write("Invalid\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
