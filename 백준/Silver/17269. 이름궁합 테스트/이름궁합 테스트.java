import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");
		char[] name1 = input[0].toCharArray();
		char[] name2 = input[1].toCharArray();

		Queue<Integer> que = new LinkedList<>();

		Map<Character, Integer> map = new HashMap<>();

		map.put('A', 3);
		map.put('B', 2);
		map.put('C', 1);
		map.put('D', 2);
		map.put('E', 4);
		map.put('F', 3);
		map.put('G', 1);
		map.put('H', 3);
		map.put('I', 1);
		map.put('J', 1);
		map.put('K', 3);
		map.put('L', 1);
		map.put('M', 3);
		map.put('N', 2);
		map.put('O', 1);
		map.put('P', 2);
		map.put('Q', 2);
		map.put('R', 2);
		map.put('S', 1);
		map.put('T', 2);
		map.put('U', 1);
		map.put('V', 1);
		map.put('W', 1);
		map.put('X', 2);
		map.put('Y', 2);
		map.put('Z', 1);

		int len = Math.max(name1.length, name2.length);

		for (int i = 0; i < len; i++) {
			if (i < name1.length) {
				que.offer(map.get(name1[i]));
			}
			if (i < name2.length) {
				que.offer(map.get(name2[i]));
			}
		}

		while (que.size() > 2) {
			int size = que.size();
			int now = que.poll();
			int next = 0;

			for (int i = 0; i < size - 1; i++) {
				next = que.poll();
				int val = now + next;
				if (val >= 10)
					val %= 10;
				que.offer(val);
				now = next;
			}
		}

		bw.write(Integer.toString(que.poll() * 10 + que.poll()) + "%");

		bw.flush();
		bw.close();
	}

}
