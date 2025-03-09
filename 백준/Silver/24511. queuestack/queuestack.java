import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

// 두 번째 시도 : stack 일 경우는 고려하지 않도록 하여 queue 만 가지고 수행. 기존 값 넣을 때 순서 유의.

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;

		int N = Integer.parseInt(br.readLine());

		input = br.readLine().split(" ");

		// false: 큐, true: 스택
		boolean[] queuestack = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (input[i].equals("1"))
				queuestack[i] = true;
		}

		Deque<Integer> que = new ArrayDeque<>();

		input = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			// queue 일 경우만 고려해준다.
			if (!queuestack[i])
				que.addLast(Integer.parseInt(input[i]));
		}

		int M = Integer.parseInt(br.readLine());

		input = br.readLine().split(" ");

		for (int i = 0; i < M; i++) {
			int C = Integer.parseInt(input[i]);

			que.addFirst(C);
			bw.write(que.removeLast() + " ");

		}
		bw.flush();
		bw.close();

	}

}
