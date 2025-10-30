import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	static class Lesson {
		int start, end;

		public Lesson(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		Lesson[] arr = new Lesson[N];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			arr[i] = new Lesson(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}

		Arrays.sort(arr, (a, b) -> {
			if (a.start != b.start) {
				return a.start - b.start;
			}

			return a.end - b.end;
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (Lesson now : arr) {
			if (!pq.isEmpty() && pq.peek() <= now.start) {
				pq.poll();
			}
			pq.offer(now.end);
		}

		bw.write(Integer.toString(pq.size()));

		bw.flush();
		bw.close();
	}

}
