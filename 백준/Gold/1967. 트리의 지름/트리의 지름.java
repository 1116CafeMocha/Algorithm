import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static class Edge {
		int to, w;

		Edge(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}

	public static int N;
	public static List<Edge>[] g;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		if (N == 1) {
			bw.write("0\n");
			bw.flush();
			bw.close();
			return;
		}

		g = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			g[i] = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);
			g[a].add(new Edge(b, w));
			g[b].add(new Edge(a, w));
		}

		int[] res1 = bfs(1);
		int A = res1[0];

		int[] res2 = bfs(A);
		int diameter = res2[1];

		bw.write(Integer.toString(diameter));

		bw.flush();
		bw.close();
	}

	static int[] bfs(int start) {
		boolean[] visited = new boolean[N + 1];
		int[] dist = new int[N + 1];

		ArrayDeque<Integer> q = new ArrayDeque<>();
		visited[start] = true;
		dist[start] = 0;
		q.offer(start);

		int farNode = start, farDist = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (Edge e : g[cur]) {
				if (!visited[e.to]) {
					visited[e.to] = true;
					dist[e.to] = dist[cur] + e.w;
					q.offer(e.to);

					if (dist[e.to] > farDist) {
						farDist = dist[e.to];
						farNode = e.to;
					}
				}
			}
		}
		return new int[] { farNode, farDist };
	}
}
