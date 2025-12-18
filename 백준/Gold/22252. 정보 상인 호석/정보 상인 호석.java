import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int Q = Integer.parseInt(br.readLine());

		Map<String, PriorityQueue<Integer>> map = new HashMap<>();

		long sum = 0L;

		while (Q-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int order = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			if (order == 1) {
				int K = Integer.parseInt(st.nextToken());
				if (!map.containsKey(name))
					map.put(name, new PriorityQueue<>(Collections.reverseOrder()));

				for (int i = 0; i < K; i++)
					map.get(name).add(Integer.parseInt(st.nextToken()));
			} else {
				int B = Integer.parseInt(st.nextToken());
				
				if(!map.containsKey(name)) continue;
				if(B > map.get(name).size()) B = map.get(name).size();

				for (int i = 0; i < B; i++)
					sum += map.get(name).poll();
			}
		}
		
		bw.write(Long.toString(sum));
		
		bw.flush();
		bw.close();
	}

}
