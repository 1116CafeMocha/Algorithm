import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int max = 0;

		Map<Long, Integer> map = new TreeMap<>();

		for (int i = 0; i < N; i++) {
			Long input = Long.parseLong(br.readLine());
			map.put(input, map.getOrDefault(input, 0) + 1);
			max = Math.max(map.get(input), max);
		}

		for (Long now : map.keySet()) {
			int val = map.get(now);
			if (val == max) {
				bw.write(Long.toString(now));
				break;
			}
		}

		bw.flush();
		bw.close();
	}
}
