import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());

		if (A + B + C == 180) {
			if (A == B && B == C)
				bw.write("Equilateral");
			else if (A == B || B == C || A == C) {
				bw.write("Isosceles");
			} else {
				bw.write("Scalene");
			}
		} else {
			bw.write("Error");
		}

		bw.flush();
		bw.close();
	}
}
