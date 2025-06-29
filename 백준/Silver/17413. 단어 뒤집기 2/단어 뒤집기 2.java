import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	static char[] S;
	static int idx = -1;
	static boolean ignore;
	static Stack<Character> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		S = br.readLine().toCharArray();
		stack = new Stack<>();

		for (int i = 0; i < S.length; i++) {
			if (S[i] == '<') {
				if (!stack.isEmpty()) {
					reverse();
				}
				ignore = true;
			}
			if (S[i] == '>') {
				ignore = false;
				continue;
			}
			if (ignore)
				continue;

			if (!stack.isEmpty() && S[i] == ' ') {
				reverse();
				continue;
			}

			if (idx == -1) {
				idx = i;
			}

			stack.add(S[i]);

			if (!stack.isEmpty() && i == S.length - 1) {
				reverse();
			}
		}

		for (char now : S)
			bw.write(now);

		bw.flush();
		bw.close();
	}

	static void reverse() {
		if (ignore)
			return;
		int size = stack.size();
		for (int i = idx; i < idx + size; i++) {
			S[i] = stack.pop();
		}
		idx = -1;
	}
}
