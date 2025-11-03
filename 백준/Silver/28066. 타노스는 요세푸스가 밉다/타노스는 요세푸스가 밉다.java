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

		String[] input = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		Deque<Integer> dq = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			dq.addLast(i);
		}

		while (dq.size() >= K) {
			int keep = dq.pollFirst();
			for (int i = 1; i <= K - 1; i++) {
				dq.pollFirst();
			}
			dq.addLast(keep);
		}

		bw.write(Integer.toString(dq.pollFirst()));

		bw.flush();
		bw.close();
	}

}
