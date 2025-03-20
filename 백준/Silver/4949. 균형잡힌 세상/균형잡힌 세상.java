import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 백준 4949번. 균형잡힌 세상

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;
		Stack<String> stack = new Stack<>();

		loop: while (true) {
			stack.clear();
			input = br.readLine().split("");

			if (input.length == 1 && input[0].equals("."))
				break;

			for (int i = 0; i < input.length; i++) {
				String now = input[i];

				if (now.equals("(") || now.equals("[")) {
					stack.add(now);
				}
				if (now.equals(")")) {
					if (!stack.isEmpty() && stack.peek().equals("(")) {
						stack.pop();
					} else {
						bw.write("no\n");
						continue loop;
					}
				}
				if (now.equals("]")) {
					if (!stack.isEmpty() && stack.peek().equals("[")) {
						stack.pop();
					} else {
						bw.write("no\n");
						continue loop;
					}
				}
			}

			if (stack.isEmpty()) {
				bw.write("yes\n");
			} else {
				bw.write("no\n");
			}
		}
		bw.flush();
		bw.close();
	}

}
