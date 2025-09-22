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
		int MAX = -1;
		int MIN = Integer.MAX_VALUE;

		Deque<Integer> dq = new ArrayDeque<>();

		while (N-- > 0) {
			String[] input = br.readLine().split(" ");

			int order = Integer.parseInt(input[0]);

			if (order == 2) {
				dq.poll();
			} else {
				int student = Integer.parseInt(input[1]);
				dq.offerLast(student);
				if (dq.size() > MAX) {
					MAX = dq.size();
					MIN = dq.peekLast();
				} else if (dq.size() == MAX) {
					MIN = Math.min(MIN, dq.peekLast());
				}
			}
		}

		bw.write(MAX + " " + MIN);

		bw.flush();
		bw.close();
	}

}
