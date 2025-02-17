import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		int input, result = 0;

		for (int i = 0; i < K; i++) {
			input = Integer.parseInt(br.readLine());
			if (input == 0) {
				result -= stack.pop();
			} else {
				stack.add(input);
				result += input;
			}
		}

		System.out.println(result);

	}

}