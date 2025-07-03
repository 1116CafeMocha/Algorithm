import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

public class Main {
	static BufferedWriter bw;
	static int N, M;
	static int[] arr, selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");

		TreeSet<Integer> set = new TreeSet<>();

		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(input[i]));
		}

		int size = set.size();
		arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = set.pollFirst();
		}

		selected = new int[M];

		dfs(0, 0);

		bw.flush();
		bw.close();
	}

	static void dfs(int idx, int start) throws IOException {
		if (idx == M) {
			for (int now : selected)
				bw.write(now + " ");
			bw.newLine();
			return;
		}

		for (int i = start; i < arr.length; i++) {
			selected[idx] = arr[i];
			dfs(idx + 1, i);
		}
	}

}
