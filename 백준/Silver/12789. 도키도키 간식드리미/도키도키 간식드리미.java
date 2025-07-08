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
		boolean isNice = false;
		String[] input = br.readLine().split(" ");
		int[] people = new int[N];

		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(input[i]);
		}

		Stack<Integer> stack = new Stack<>();

		int nowNum = 1;

		for (int i = 0; i <= N; i++) {

			while (!stack.isEmpty()) {
				if (stack.peek() != nowNum)
					break;
				stack.pop();
				nowNum++;
			}

			if (i == N) {
				if (nowNum == N + 1)
					isNice = true;
				break;
			}

			if (people[i] == nowNum) {
				nowNum++;
			} else {
				stack.add(people[i]);
			}

		}

		if (isNice)
			bw.write("Nice");
		else
			bw.write("Sad");

		bw.flush();
		bw.close();
	}
}
