import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> que = new ArrayDeque<>();
		boolean[] visited = new boolean[100001];
		int[] dist = new int[100001];

		que.offer(N);
		visited[N] = true;

		while (!que.isEmpty()) {
			int now = que.poll();

			if (now == K) {
				System.out.println(dist[now]);
				return;
			}

			int[] nexts = { now - 1, now + 1, now * 2 };

			for (int next : nexts) {
				if (next < 0)
					continue;
				if (next > 100000)
					continue;
				if (visited[next])
					continue;

				visited[next] = true;
				dist[next] = dist[now] + 1;
				que.offer(next);
			}
		}

	}

}