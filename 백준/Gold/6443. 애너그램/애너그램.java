import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int[] count = new int[26];
	static char[] out;
	static StringBuilder sb = new StringBuilder();

	static void dfs(int depth, int L) {
		if (depth == L) {
			sb.append(out).append('\n');
			return;
		}

		for (int c = 0; c < 26; c++) {
			if (count[c] == 0)
				continue;
			count[c]--;
			out[depth] = (char) ('a' + c);
			dfs(depth + 1, L);
			count[c]++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			Arrays.fill(count, 0);
			char[] input = br.readLine().toCharArray();
			for (char now : input) {
				count[now - 'a']++;
			}
			out = new char[input.length];
			dfs(0, input.length);
		}
		bw.write(sb.toString());

		bw.flush();
		bw.close();
	}

}
