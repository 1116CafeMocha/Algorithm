import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 노드 이름은 대문자 => 26
	static int[] left = new int[26];
	static int[] right = new int[26];

	static StringBuilder pre = new StringBuilder();
	static StringBuilder in = new StringBuilder();
	static StringBuilder post = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Arrays.fill(left, -1);
		Arrays.fill(right, -1);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char P = st.nextToken().charAt(0);
			char L = st.nextToken().charAt(0);
			char R = st.nextToken().charAt(0);

			int idx = P - 'A';

			if (L == '.')
				left[idx] = -1;
			else
				left[idx] = L - 'A';

			if (R == '.')
				right[idx] = -1;
			else
				right[idx] = R - 'A';
		}

		int root = 0;
		preorder(root);
		inorder(root);
		postorder(root);

		StringBuilder out = new StringBuilder();
		out.append(pre).append('\n');
		out.append(in).append('\n');
		out.append(post).append('\n');
		System.out.print(out);
	}

	static void preorder(int now) {
		if (now == -1)
			return;
		pre.append((char) (now + 'A'));
		preorder(left[now]);
		preorder(right[now]);
	}

	static void inorder(int now) {
		if (now == -1)
			return;
		inorder(left[now]);
		in.append((char) (now + 'A'));
		inorder(right[now]);
	}

	static void postorder(int now) {
		if (now == -1)
			return;
		postorder(left[now]);
		postorder(right[now]);
		post.append((char) (now + 'A'));
	}

}