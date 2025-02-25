import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 스택 수열

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		Queue<Integer> nums = new LinkedList<>();
		Queue<Integer> que = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();

		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}

		for (int i = 0; i < n; i++) {
			que.add(Integer.parseInt(br.readLine()));
		}

		while (!que.isEmpty()) {
			int nowNum = que.peek();

			if (stack.isEmpty() || stack.peek() < nowNum) {
				sb.append("+\n");
				stack.add(nums.poll());
				continue;
			}

			if (stack.peek() > nowNum) {
				break;
			}

			if (stack.peek() == nowNum) {
				que.poll();
				stack.pop();
				sb.append("-\n");
			}
		}

		if (que.isEmpty())
			System.out.println(sb);
		else {
			System.out.println("NO");
		}
	}

}
