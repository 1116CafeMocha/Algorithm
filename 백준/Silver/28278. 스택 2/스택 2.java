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

		int N = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");

			if (input[0].equals("1")) {
				stack.add(Integer.parseInt(input[1]));
			}

			else if (input[0].equals("2")) {
				if (stack.isEmpty()) {
					bw.write("-1\n");
					continue;
				}

				bw.write(Integer.toString(stack.pop()));
				bw.newLine();
			} else if (input[0].equals("3")) {
				bw.write(Integer.toString(stack.size()));
				bw.newLine();
			} else if (input[0].equals("4")) {
				if (stack.isEmpty()) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			} else if (input[0].equals("5")) {
				if (stack.isEmpty()) {
					bw.write("-1\n");
					continue;
				}
				bw.write(Integer.toString(stack.peek()));
				bw.newLine();
			}
		}

		bw.flush();
		bw.close();
	}
}
