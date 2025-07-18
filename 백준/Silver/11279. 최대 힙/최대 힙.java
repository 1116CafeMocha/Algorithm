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
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		while (N-- > 0) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				if (pq.isEmpty()) {
					bw.write("0\n");
				} else {
					bw.write(pq.poll() + "\n");
				}
			} else {
				pq.offer(input);
			}
		}

		bw.flush();
		bw.close();
	}
}
