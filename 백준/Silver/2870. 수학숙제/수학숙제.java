import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		List<String> list = new ArrayList<>();

		while (N-- > 0) {
			char[] input = br.readLine().toCharArray();

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < input.length; i++) {
				char now = input[i];
				if (Character.isDigit(now)) {
					sb.append(now);
				} else {
					if (sb.length() > 0) {
						list.add(normalize(sb));
						sb.setLength(0);
					}
				}
			}
			if (sb.length() > 0)
				list.add(normalize(sb));
		}

		Collections.sort(list, (a, b) -> {
			if (a.length() != b.length())
				return a.length() - b.length();
			return a.compareTo(b);
		});

		for (String now : list) {
			bw.write(now);
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}

	static String normalize(CharSequence str) {
		int i = 0, len = str.length();
		while (i < len - 1 && str.charAt(i) == '0')
			i++;
		return str.subSequence(i, len).toString();
	}

}
