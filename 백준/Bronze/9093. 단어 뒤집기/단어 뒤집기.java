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

		int T = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();

		for (int testcase = 0; testcase < T; testcase++) {
			char[] arr = br.readLine().toCharArray();
			for (int i = 0; i <= arr.length; i++) {
				if (i == arr.length || arr[i] == ' ') {
					while (!stack.isEmpty()) {
						bw.write(stack.pop());
					}
					if (i != arr.length) bw.write(" ");
				} else {
					stack.add(arr[i]);
				}
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}

}
