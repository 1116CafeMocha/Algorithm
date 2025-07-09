// 백준 2252번. 줄 세우기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		// 인접 리스트 그래프
		List<Integer>[] graph = new ArrayList[N + 1];
		// 진입 차수 배열
		int[] inDegree = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);

			// A -> B
			graph[A].add(B);
			// A에서 B로 들어가므로 B의 진입 차수 증가
			inDegree[B]++;
		}

		// 위상 정렬을 위한 큐
		Queue<Integer> que = new ArrayDeque<>();

		// 진입 차수가 0인 노드들을 큐에 넣는다.
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				que.offer(i);
			}
		}

		while (!que.isEmpty()) {
			int now = que.poll();
			bw.write(now + " ");

			for (int next : graph[now]) {
				inDegree[next]--;
				if (inDegree[next] == 0) {
					que.offer(next);
				}
			}
		}

		bw.flush();
		bw.close();
	}
}
