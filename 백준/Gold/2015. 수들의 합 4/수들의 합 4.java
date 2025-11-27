import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		StringTokenizer st = new StringTokenizer(br.readLine());

		long sum = 0L;
		long answer = 0L;

		Map<Long, Long> count = new HashMap<>();
		count.put(0L, 1L);

		for (int i = 0; i < N; i++) {
			long x = Long.parseLong(st.nextToken());
			sum += x;

			long target = sum - K;

			if (count.containsKey(target)) {
				answer += count.get(target);
			}
			count.put(sum, count.getOrDefault(sum, 0L) + 1L);
		}

		bw.write(Long.toString(answer));

		bw.flush();
		bw.close();
	}

}
