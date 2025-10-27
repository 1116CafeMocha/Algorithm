import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	static int L, C;
	static char[] chars;
	static boolean[] isMo;
	static Set<String> answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		L = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);

		chars = br.readLine().replace(" ", "").toCharArray();
		Arrays.sort(chars);

		isMo = new boolean[C];

		for (int i = 0; i < C; i++) {
			char now = chars[i];
			if (now == 'a' || now == 'e' || now == 'i' || now == 'o' || now == 'u') {
				isMo[i] = true;
			}
		}

		answer = new TreeSet<>();

		comb(0, 0, 0, new char[L]);

		for (String now : answer) {
			bw.write(now);
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}

	static void comb(int start, int len, int moCnt, char[] str) {
		if (C - start < L - len)
			return;

		if (len == L) {
			if (moCnt >= 1 && len - moCnt >= 2) {
				answer.add(String.valueOf(str));
			}
			return;
		}

		for (int i = start; i < C; i++) {
			str[len] = chars[i];

			comb(i + 1, len + 1, moCnt + (isMo[i] ? 1 : 0), str);
		}
	}
}
