import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");

		LinkedList<Integer> dq = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			dq.offerLast(i);
		}

		int answer = 0;

		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(input[i]);

			if (dq.peekFirst() != null && dq.peekFirst() == target) {
				dq.pollFirst();
				continue;
			}

			int idx = 0;
			for (Integer x : dq) {
				if (x == target)
					break;
				idx++;
			}

			int leftMoves = idx;
			int rightMoves = dq.size() - idx;

			if (leftMoves <= rightMoves) {
				for (int k = 0; k < leftMoves; k++) {
					dq.offerLast(dq.pollFirst());
				}
				answer += leftMoves;
			} else {

				for (int k = 0; k < rightMoves; k++) {
					dq.offerFirst(dq.pollLast());
				}
				answer += rightMoves;
			}

			dq.pollFirst();
		}

		bw.write(Integer.toString(answer));

		bw.flush();
		bw.close();
	}
}
