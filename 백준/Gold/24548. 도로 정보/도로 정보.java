import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		char[] input = br.readLine().toCharArray();

		Map<String, Long> map = new HashMap<>();

		map.put("0,0,0,0", 1L);

		long answer = 0;

		int T = 0;
		int G = 0;
		int F = 0;
		int P = 0;

		for (int i = 0; i < N; i++) {
			char now = input[i];

			if (now == 'T')
				T = (T + 1) % 3;
			else if (now == 'G')
				G = (G + 1) % 3;
			else if (now == 'F')
				F = (F + 1) % 3;
			else
				P = (P + 1) % 3;

			String str = T + "," + G + "," + F + "," + P;

			answer += map.getOrDefault(str, 0L);
			map.put(str, map.getOrDefault(str, 0L) + 1);
		}

		bw.write(Long.toString(answer));

		bw.flush();
		bw.close();
	}
}
