import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
	static final int INF = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		if (N >= K) {
			System.out.println(N - K);
			return;
		}

		int[] dist = new int[100_001];
		Arrays.fill(dist, INF);

		Deque<Integer> dq = new ArrayDeque<>();

		dist[N] = 0;
		dq.add(N);

		while (!dq.isEmpty()) {
			int x = dq.pollFirst();
			if (x == K)
				break;

			int nx = x * 2;
			if (nx < 100_001 && dist[nx] > dist[x]) {
				dist[nx] = dist[x];
				dq.addFirst(nx);
			}

			nx = x - 1;
			if (nx >= 0 && dist[nx] > dist[x] + 1) {
				dist[nx] = dist[x] + 1;
				dq.addLast(nx);
			}

			nx = x + 1;
			if (nx < 100_001 && dist[nx] > dist[x] + 1) {
				dist[nx] = dist[x] + 1;
				dq.addLast(nx);
			}
		}

		bw.write(Integer.toString(dist[K]));

		bw.flush();
		bw.close();
	}

}
