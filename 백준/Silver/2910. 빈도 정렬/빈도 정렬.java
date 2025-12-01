import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static class Message {
		int num;
		int idx;
		int count;

		Message(int num, int idx, int count) {
			this.num = num;
			this.idx = idx;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		List<Message> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();

		int index = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			if (map.containsKey(now)) {
				list.get(map.get(now)).count++;
			} else {
				map.put(now, index);
				list.add(new Message(now, index, 1));
				index++;
			}
		}

		list.sort((a, b) -> {
			if (a.count != b.count)
				return b.count - a.count;
			return a.idx - b.idx;
		});

		for (Message cur : list) {
			for (int i = 0; i < cur.count; i++) {
				bw.write(cur.num + " ");
			}
		}

		bw.flush();
		bw.close();
	}

}
