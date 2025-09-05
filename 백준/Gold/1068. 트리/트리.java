import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int root = -1;
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int delNum = Integer.parseInt(br.readLine());

		List<List<Integer>> tree = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 0; i < N; i++) {
			int par = Integer.parseInt(input[i]);

			if (par == -1) {
				root = i;
				continue;
			}

			tree.get(par).add(i);
		}

		if (delNum == root) {
			System.out.println(0);
			return;
		}

		boolean[] deleted = new boolean[N];
		Queue<Integer> que = new LinkedList<>();

		que.offer(delNum);
		deleted[delNum] = true;

		while (!que.isEmpty()) {
			int now = que.poll();

			for (int val : tree.get(now)) {
				if (!deleted[val]) {
					deleted[val] = true;
					que.offer(val);
				}
			}
		}

		int count = 0;

		for (int i = 0; i < N; i++) {
			if (deleted[i])
				continue;
			if (i == delNum)
				continue;

			int aliveChild = 0;
			for (int c : tree.get(i)) {
				if (!deleted[c])
					aliveChild++;
			}
			if (aliveChild == 0)
				count++;
		}

		bw.write(Integer.toString(count));

		bw.flush();
		bw.close();
	}
}
