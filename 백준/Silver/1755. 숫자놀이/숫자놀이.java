import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 권장 풀이 코드

public class Main {

	static String[] words = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

	static class NumberWord implements Comparable<NumberWord> {
		int number;
		String word;

		public NumberWord(int number, String word) {
			this.number = number;
			this.word = word;
		}

		@Override
		public int compareTo(NumberWord o) {
			return this.word.compareTo(o.word);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		List<NumberWord> list = new ArrayList<>();

		for (int i = M; i <= N; i++) {
			String num = Integer.toString(i);
			StringBuilder str = new StringBuilder();

			for (int j = 0; j < num.length(); j++) {
				int now = num.charAt(j) - '0';
				str.append(words[now]);

				if (j != num.length() - 1) {
					str.append(" ");
				}
			}

			list.add(new NumberWord(i, str.toString()));
		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			bw.write(Integer.toString(list.get(i).number));

			if ((i + 1) % 10 == 0) {
				bw.newLine();
			} else if (i != list.size() - 1) {
				bw.write(" ");
			}

		}

		bw.flush();
		bw.close();
	}

}