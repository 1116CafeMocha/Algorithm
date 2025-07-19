import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		Deque<int[]> dq = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			dq.add(new int[] { i + 1, Integer.parseInt(input[i]) });
		}

		StringBuilder sb = new StringBuilder();

		int[] now = dq.pollFirst();
		sb.append(now[0]).append(" ");

		while (!dq.isEmpty()) {
			int val = now[1];

			if (val > 0) {
				for (int i = 0; i < val - 1; i++) {
					dq.addLast(dq.pollFirst());
				}
				now = dq.pollFirst();
			} else {
				for (int i = 0; i < Math.abs(val); i++) {
					dq.addFirst(dq.pollLast());
				}
				now = dq.pollFirst();
			}

			sb.append(now[0]).append(" ");
		}

		bw.write(sb.toString());

		bw.flush();
		bw.close();
	}
}
