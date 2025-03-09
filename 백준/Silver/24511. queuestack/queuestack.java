import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

// 첫 시도 : dequeue 배열로 큐와 스택 모두 고려하여 수행. => 시간 초과

//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		String[] input;
//
//		int N = Integer.parseInt(br.readLine());
//
//		input = br.readLine().split(" ");
//
//		// false: 큐, true: 스택
//		boolean[] queuestack = new boolean[N];
//		for (int i = 0; i < N; i++) {
//			if (input[i].equals("1"))
//				queuestack[i] = true;
//		}
//
//		Deque<Integer>[] deque = new ArrayDeque[N];
//		for (int i = 0; i < N; i++)
//			deque[i] = new ArrayDeque<>();
//
//		input = br.readLine().split(" ");
//
//		for (int i = 0; i < N; i++) {
//			deque[i].addFirst(Integer.parseInt(input[i]));
//		}
//
//		int M = Integer.parseInt(br.readLine());
//
//		input = br.readLine().split(" ");
//
//		for (int i = 0; i < M; i++) {
//			int C = Integer.parseInt(input[i]);
//			int X = C;
//
//			for (int k = 0; k < N; k++) {
//				// 스택일 경우
//				if (queuestack[k]) {
//					deque[k].addFirst(X);
//					X = deque[k].removeFirst();
//					if (k == N - 1)
//						bw.write(X + " ");
//				}
//
//				// 큐일 경우
//				else {
//					deque[k].addFirst(X);
//					X = deque[k].removeLast();
//					if (k == N - 1)
//						bw.write(X + " ");
//				}
//			}
//
//		}
//		bw.flush();
//		bw.close();
//
//	}
//
//}

// 두 번째 시도 : stack 일 경우는 고려하지 않도록 하여 queue 만 가지고 수행. 

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
