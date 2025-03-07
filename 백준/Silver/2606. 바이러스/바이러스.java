// 백준 2606번. 바이러스

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		// 컴퓨터의 수
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");

			graph.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
			graph.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
		}

		System.out.println(bfs(graph, N));
	}

	public static int bfs(List<List<Integer>> graph, int N) {
		Queue<Integer> que = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];

		que.offer(1);
		visited[1] = true;
		int count = 0;

		while (!que.isEmpty()) {
			int now = que.poll();

			for (int next : graph.get(now)) {
				if (visited[next])
					continue;

				visited[next] = true;
				que.offer(next);
				count++;
			}
		}

		return count;
	}

}
