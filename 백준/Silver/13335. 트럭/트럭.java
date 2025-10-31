import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class truck {
		int idx;
		int weight;
		int count = 0;

		truck(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int W = Integer.parseInt(input[1]);
		int L = Integer.parseInt(input[2]);

		truck[] trucks = new truck[N];

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		for (int i = 0; i < N; i++) {
			trucks[i] = new truck(i, Integer.parseInt(st.nextToken()));
		}

		Queue<truck> que = new ArrayDeque<>();

		que.offer(trucks[0]);
		int time = 1;
		int idx = 1;
		int sum = trucks[0].weight;
		trucks[0].count++;

		while (!que.isEmpty()) {
			time++;

			for (truck now : que) {
				now.count++;
			}

			if (que.peek().count > W) {
				sum -= que.peek().weight;
				que.poll();
			}

			if (idx < N) {
				truck next = trucks[idx];

				if (que.size() < W && sum + next.weight <= L) {
					next.count++;
					sum += next.weight;
					idx++;
					que.offer(next);
				}
			}

		}

		bw.write(Integer.toString(time));

		bw.flush();
		bw.close();
	}

}
