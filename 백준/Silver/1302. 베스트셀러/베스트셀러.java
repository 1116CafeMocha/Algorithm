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
		int MAX = 0;
		Map<String, Integer> map = new TreeMap<>();

		while (N-- > 0) {
			String str = br.readLine();

			if (!map.containsKey(str))
				map.put(str, 0);
			else
				map.put(str, map.get(str) + 1);
			MAX = Math.max(map.get(str), MAX);
		}

		for (String now : map.keySet()) {
			if (map.get(now) == MAX) {
				bw.write(now);
				break;
			}
		}

		bw.flush();
		bw.close();
	}

}
