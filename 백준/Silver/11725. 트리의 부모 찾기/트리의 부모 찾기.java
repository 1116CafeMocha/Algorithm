import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	static int N;
	static List<List<Integer>> tree;
	static Map<Integer, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		String[] input;

		tree = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 1; i < N; i++) {
			input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);

			tree.get(A).add(B);
			tree.get(B).add(A);
		}

		map = new HashMap<>();

		mk(1);

		for (int i = 2; i <= N; i++) {
			bw.write(Integer.toString(map.get(i)));
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}

	static void mk(int now) {
		int size = tree.get(now).size();

		for (int i = 0; i < size; i++) {
			if (map.containsKey(tree.get(now).get(i)))
				continue;
			map.put(tree.get(now).get(i), now);
			mk(tree.get(now).get(i));
		}
	}
}
