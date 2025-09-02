import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

	static int cal(int N) {
		int val = N;
		while (N > 0) {
			val += N % 10;
			N /= 10;
		}
		return val;
	}

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean[] isSelf = new boolean[10001];

		for (int i = 1; i <= 10000; i++) {
			int val = cal(i);
			if (val <= 10000)
				isSelf[val] = true;
		}

		for (int i = 1; i <= 10000; i++) {
			if (!isSelf[i]) {
				bw.write(Integer.toString(i));
				bw.newLine();
			}
		}

		bw.flush();
		bw.close();
	}
}
