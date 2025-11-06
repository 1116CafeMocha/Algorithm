import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int[] size;

	static int find(int x) {
		while (x != parent[x]) {
			parent[x] = parent[parent[x]];
			x = parent[x];
		}
		return x;
	}

	static void union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		if (ra == rb)
			return;

		if (size[ra] < size[rb]) {
			int t = ra;
			ra = rb;
			rb = t;
		}

		parent[rb] = ra;
		size[ra] += size[rb];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		parent = new int[N + 1];
		size = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
			size[i] = 1;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (op == 0) {
				union(a, b);
			} else {
				bw.write(find(a) == find(b) ? "YES" : "NO");
				bw.newLine();
			}
		}

		bw.flush();
		bw.close();
	}

}
