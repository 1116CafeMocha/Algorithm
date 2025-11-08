import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class Tower {
		int height, idx;

		Tower(int height, int idx) {
			this.height = height;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		int[] arr = new int[N];
		int[] answer = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int MAX = arr[N - 1];
		Stack<Tower> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			int now = arr[i];

			while (!stack.isEmpty() && stack.peek().height < now) {
				stack.pop();
			}

			if (!stack.isEmpty()) {
				answer[i] = stack.peek().idx;
			} else {
				answer[i] = 0;
			}

			stack.push(new Tower(now, i + 1));
		}

		for (int i = 0; i < N; i++) {
			bw.write(answer[i] + " ");
		}

		bw.flush();
		bw.close();
	}

}
