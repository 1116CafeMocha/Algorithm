import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());

			if (maxHeap.isEmpty() || input <= maxHeap.peek()) {
				maxHeap.offer(input);
			} else {
				minHeap.offer(input);
			}

			if (maxHeap.size() > minHeap.size() + 1) {
				minHeap.offer(maxHeap.poll());
			} else if (minHeap.size() > maxHeap.size()) {
				maxHeap.offer(minHeap.poll());
			}

			bw.write(maxHeap.peek() + "\n");
		}

		bw.flush();
		bw.close();
	}
}
