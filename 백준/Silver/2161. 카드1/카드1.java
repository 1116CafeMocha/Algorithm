// 백준 2161번. 카드1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Queue<Integer> que = new LinkedList<>();
		Queue<Integer> answer = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			que.add(i);
		}

		while (!que.isEmpty()) {
			answer.add(que.poll());
			if (que.isEmpty())
				continue;
			que.add(que.poll());
		}

		while (!answer.isEmpty()) {
			System.out.print(answer.poll() + " ");
		}

	}

}
