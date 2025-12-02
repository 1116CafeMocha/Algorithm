import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
	static String str;
	static int len;
	// 한 경로의 모든 문자열 길이의 총합
	static int totalLen;
	static String s;
	static HashSet<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		str = br.readLine();
		len = str.length();
		totalLen = len * (len + 1) / 2;

		set = new HashSet<>();

		for (int i = 0; i < len; i++) {
			dfs(i, i, str.substring(i, i + 1));
		}

		bw.write(Integer.toString(set.size()));

		bw.flush();
		bw.close();
	}

	static void dfs(int left, int right, String path) {
		// N을 완성한 경우
		if (path.length() == totalLen) {
			set.add(path);
			return;
		}

		// 왼쪽으로
		if (left > 0) {
			String next = path + str.substring(left - 1, right + 1);
			dfs(left - 1, right, next);
		}

		if (right < len - 1) {
			String next = path + str.substring(left, right + 2);
			dfs(left, right + 1, next);
		}
	}

}
