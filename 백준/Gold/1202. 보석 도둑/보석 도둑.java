import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	static class Jewel implements Comparable<Jewel> {
		int weight;
		int value;

		Jewel(int w, int v) {
			this.weight = w;
			this.value = v;
		}

		// 오름차순 정렬
		public int compareTo(Jewel o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		Jewel[] jewels = new Jewel[N];
		int[] bags = new int[K];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			int w = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);
			jewels[i] = new Jewel(w, v);
		}

		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(jewels);
		Arrays.sort(bags);

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		long result = 0;
		int j = 0;

		for (int i = 0; i < K; i++) {
			int bag = bags[i];

			while (j < N && jewels[j].weight <= bag) {
				pq.offer(jewels[j].value);
				j++;
			}

			if (!pq.isEmpty()) {
				result += pq.poll();
			}
		}

		bw.write(Long.toString(result));

		bw.flush();
		bw.close();
	}

}
