import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static BufferedWriter bw;
	static int N;
	static int[] nums;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		nums = new int[N];
		arr = new int[N];
		visited = new boolean[N];

		for (int i = 1; i <= N; i++) {
			nums[i - 1] = i;
		}

		comb(0);

		bw.flush();
		bw.close();
	}

	static void comb(int depth) throws IOException {
		if (depth == N) {
			for (int i = 0; i < N; i++) {
				bw.write(arr[i] + " ");
			}
			bw.newLine();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			arr[depth] = nums[i];
			comb(depth + 1);
			visited[i] = false;
		}
	}

}
