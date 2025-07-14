import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testcaseNums = Integer.parseInt(br.readLine());

		for (int testcase = 0; testcase < testcaseNums; testcase++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);

			Queue<int[]> que = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

			input = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				int priority = Integer.parseInt(input[i]);
				que.offer(new int[] { i, priority });
				pq.offer(priority);
			}

			int count = 0;
			while (!que.isEmpty()) {
				int[] now = que.poll();
				if (now[1] == pq.peek()) {
					count++;
					pq.poll();
					if (now[0] == M) {
						bw.write(count + "\n");
						break;
					}
				} else {
					que.offer(now);
				}
			}
		}

		bw.flush();
		bw.close();
	}
}
