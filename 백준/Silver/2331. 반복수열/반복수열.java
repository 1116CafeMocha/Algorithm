import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static int A, P;

	static int cal(int N) {
		int val = 0;

		while (N > 0) {
			val += (int) Math.pow((N % 10), P);
			N /= 10;
		}
		return val;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		A = Integer.parseInt(input[0]);
		P = Integer.parseInt(input[1]);

		Set<Integer> set = new HashSet<>();

		int now = A;
		set.add(A);
		while (true) {
			now = cal(now);
			if (set.contains(now)) {
				set.remove(now);
				while (true) {
					now = cal(now);
					if (set.contains(now)) {
						set.remove(now);
					} else {
						break;
					}
				}
				break;
			} else {
				set.add(now);
			}
		}

		bw.write(Integer.toString(set.size()));

		bw.flush();
		bw.close();
	}
}
