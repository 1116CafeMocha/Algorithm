import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		LinkedHashMap<Integer, Integer> frq = new LinkedHashMap<>();

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());

			frq.put(x, frq.getOrDefault(x, 0) + 1);
		}

		// 엔트리 리스트로 변환
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frq.entrySet());

		Collections.sort(list, (a, b) -> {
			return b.getValue() - a.getValue();
		});

		for (Map.Entry<Integer, Integer> e : list) {
			int num = e.getKey();
			int count = e.getValue();
			for (int i = 0; i < count; i++) {
				bw.write(num + " ");
			}
		}

		bw.flush();
		bw.close();
	}

}
