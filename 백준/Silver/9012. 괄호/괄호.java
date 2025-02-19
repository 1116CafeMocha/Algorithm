import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;
		int T = Integer.parseInt(br.readLine().strip());
		Stack<Boolean> stack = new Stack<>();

		test: for (int testcase = 0; testcase < T; testcase++) {
			stack.clear();
			input = br.readLine().split("");
			for (int i = 0; i < input.length; i++) {
				switch (input[i]) {
				case "(":
					stack.add(true);
					break;
				case ")":
					if (stack.isEmpty() || stack.peek() != true) {
						bw.write("NO\n");
						continue test;
					}
					stack.pop();
					break;
				}
			}
			if (stack.isEmpty())
				bw.write("YES\n");
			else
				bw.write("NO\n");
		}

		bw.flush();
		bw.close();
	}

}