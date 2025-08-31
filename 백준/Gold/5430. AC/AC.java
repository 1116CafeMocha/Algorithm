import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	// 현재 방향. 기본 true, 뒤집기 false
	public static boolean direction;
	public static boolean isError;

	public static void R() {
		if (direction)
			direction = false;
		else
			direction = true;
		return;
	}

	public static void D(Deque dq) {
		if (dq.isEmpty()) {
			isError = true;
			return;
		}

		if (direction) {
			dq.pollFirst();
		} else {
			dq.pollLast();
		}

		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			direction = true;
			isError = false;
			char[] P = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			Deque<Integer> dq = new ArrayDeque<>();

			String input = br.readLine();
			if (N != 0) {
				String[] arr = input.substring(1, input.length() - 1).split(",");

				for (String now : arr) {
					dq.offerLast(Integer.parseInt(now));
				}
			}

			for (char now : P) {
				if (isError) {
					break;
				}

				if (now == 'R')
					R();
				else
					D(dq);
			}

			if (isError)
				bw.write("error\n");
			else {
				bw.write("[");

				while (!dq.isEmpty()) {
					if (direction) {
						bw.write(Integer.toString(dq.pollFirst()));
						if (!dq.isEmpty())
							bw.write(",");
					} else {
						bw.write(Integer.toString(dq.pollLast()));
						if (!dq.isEmpty())
							bw.write(",");
					}
				}

				bw.write("]\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
