import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] input = br.readLine().toCharArray();

		List<Integer> list = new ArrayList<>();

		int idx = 0;

		for (char now : input) {
			if (now == '.') {
				if (!list.isEmpty()) {
					idx++;
				}
				list.add(0);
			} else {
				if (list.isEmpty()) {
					list.add(1);
				} else if (list.get(idx) == 0) {
					list.add(1);
					idx++;
				} else {
					list.set(idx, list.get(idx) + 1);
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == 0) {
				sb.append(".");
			} else {
				int now = list.get(i);

				if (now % 2 != 0) {
					System.out.println(-1);
					return;
				}

				int val = now / 4;
				now %= 4;

				while (val-- > 0) {
					sb.append("AAAA");
				}

				val = now / 2;
				while (val-- > 0) {
					sb.append("BB");
				}
			}

		}

		bw.write(sb.toString());

		bw.flush();
		bw.close();
	}

}
