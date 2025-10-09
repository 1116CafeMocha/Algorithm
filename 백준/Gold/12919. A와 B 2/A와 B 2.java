import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static String S, T;
	static boolean answer = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		S = br.readLine();
		T = br.readLine();

		dfs(T);

		if (answer)
			bw.write("1");
		else
			bw.write("0");

		bw.flush();
		bw.close();
	}

	static void dfs(String cur) {
		if (answer) {
			return;
		}

		if (cur.length() == S.length()) {
			if (cur.equals(S)) {
				answer = true;
			}
			return;
		}

		if (cur.charAt(cur.length() - 1) == 'A') {
			dfs(cur.substring(0, cur.length() - 1));
		}

		if (cur.charAt(0) == 'B') {
			StringBuilder sb = new StringBuilder(cur.substring(1));
			sb.reverse();
			dfs(sb.toString());
		}
	}
}
