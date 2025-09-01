import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N, R, C;
	static int answer = 0;

	static void solve(int size, int x, int y) {
		if (size == 1)
			return;

		int half = size / 2;
		int block = half * half;

		// 0 사분면
		if (R < x + half && C < y + half) {
			solve(half, x, y);
		}
		// 1 사분면
		else if (R < x + half && C >= y + half) {
			answer += block;
			solve(half, x, y + half);
		}
		// 2 사분면
		else if (R >= x + half && C < y + half) {
			answer += block * 2;
			solve(half, x + half, y);
		}
		// 3 사분면
		else {
			answer += block * 3;
			solve(half, x + half, y + half);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		R = Integer.parseInt(input[1]);
		C = Integer.parseInt(input[2]);

		int size = (int) Math.pow(2, N);
		solve(size, 0, 0);
		bw.write(Integer.toString(answer));

		bw.flush();
		bw.close();
	}
}
