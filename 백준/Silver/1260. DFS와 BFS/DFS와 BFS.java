import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 백준 1260번. DFS와 BFS

public class Main {
	static List<List<Integer>> graph;
	static Queue<Integer> que;
	static boolean[] visited;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		String[] input;
		input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int V = Integer.parseInt(input[2]);

		graph = new ArrayList<>();
		que = new LinkedList<>();
		visited = new boolean[N + 1];

		// graph 리스트 초기값 생성
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		// graph 정보 입력
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int vertex1 = Integer.parseInt(input[0]);
			int vertex2 = Integer.parseInt(input[1]);

			// 양방향 연결
			graph.get(vertex1).add(vertex2);
			graph.get(vertex2).add(vertex1);
		}

		// graph 오름차순 정렬
		for (int i = 0; i <= N; i++) {
			Collections.sort(graph.get(i));
		}

		dfs(V);
		bw.newLine();

		Arrays.fill(visited, false);
		que.offer(V);
		visited[V] = true;
		bfs();

		bw.flush();
		bw.close();

	}

	static void dfs(int start) throws IOException {
		visited[start] = true;
		bw.write(start + " ");

		for (int i = 0; i < graph.get(start).size(); i++) {
			int next = graph.get(start).get(i);
			if (visited[next])
				continue;
			dfs(next);
		}
	}

	static void bfs() throws IOException {
		while (!que.isEmpty()) {
			int now = que.poll();
			bw.write(now + " ");

			for (int i = 0; i < graph.get(now).size(); i++) {
				int next = graph.get(now).get(i);
				if (visited[next])
					continue;

				visited[next] = true;
				que.offer(next);
			}
		}
	}

}
