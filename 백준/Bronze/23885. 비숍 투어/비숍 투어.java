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
		long N = Long.parseLong(input[0]);
		long M = Long.parseLong(input[1]);

		input = br.readLine().split(" ");
		long Sx = Long.parseLong(input[0]);
		long Sy = Long.parseLong(input[1]);

		input = br.readLine().split(" ");
		long Ex = Long.parseLong(input[0]);
		long Ey = Long.parseLong(input[1]);

		if (Sx == Ex && Sy == Ey) {
			bw.write("YES");
		} else if (N == 1 || M == 1) {
			bw.write("NO");
		} else {
			long s = (Sx + Sy) & 1L;
			long t = (Ex + Ey) & 1L;
			bw.write(s == t ? "YES" : "NO");
		}

		bw.flush();
		bw.close();
	}
}
