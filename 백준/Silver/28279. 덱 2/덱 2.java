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
		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int order = Integer.parseInt(input[0]);

			switch (order) {
			case 1:
				deque.offerFirst(Integer.parseInt(input[1]));
				break;
			case 2:
				deque.offerLast(Integer.parseInt(input[1]));
				break;
			case 3:
				if (!deque.isEmpty()) {
					bw.write(deque.pollFirst() + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			case 4:
				if (!deque.isEmpty()) {
					bw.write(deque.pollLast() + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			case 5:
				bw.write(deque.size() + "\n");
				break;
			case 6:
				if (!deque.isEmpty()) {
					bw.write("0\n");
				} else {
					bw.write("1\n");
				}
				break;
			case 7:
				if (!deque.isEmpty()) {
					bw.write(deque.peekFirst() + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			case 8:
				if (!deque.isEmpty()) {
					bw.write(deque.peekLast() + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			default:
				break;
			}

		}

		bw.flush();
		bw.close();
	}
}
