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

		Map<String, Integer> map = new TreeMap<>();

		while (N-- > 0) {
			String[] input = br.readLine().split("\\.");
			String now = input[1];

			map.put(now, map.getOrDefault(now, 0) + 1);
		}

		for (String now : map.keySet()) {
			bw.write(now + " ");
			bw.write(Integer.toString(map.get(now)) + " ");
		}

		bw.flush();
		bw.close();
	}

}
