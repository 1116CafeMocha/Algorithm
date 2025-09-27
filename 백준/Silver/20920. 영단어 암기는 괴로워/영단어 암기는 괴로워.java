import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	static class Word {
		String w;
		int cnt;
		int len;

		Word(String w, int cnt) {
			this.w = w;
			this.cnt = cnt;
			this.len = w.length();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		Map<String, Integer> count = new HashMap<>();

		while (N-- > 0) {
			String word = br.readLine();

			if (word.length() < M)
				continue;

			count.put(word, count.getOrDefault(word, 0) + 1);
			count.compute(word, (k, v) -> v == null ? 1 : v + 1);
		}

		List<Word> list = new ArrayList<>(count.size());
		for (Map.Entry<String, Integer> e : count.entrySet()) {
			list.add(new Word(e.getKey(), e.getValue()));
		}

		Collections.sort(list, (a, b) -> {
			if (a.cnt != b.cnt)
				return b.cnt - a.cnt;
			if (a.len != b.len)
				return b.len - a.len;
			return a.w.compareTo(b.w);
		});

		StringBuilder sb = new StringBuilder();
		for (Word wd : list)
			sb.append(wd.w).append('\n');
		bw.write(sb.toString());

		bw.flush();
		bw.close();
	}

}
