import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// 트라이 연습... 어렵다

public class Main {
	static Node root;
	static Map<String, Integer> map;

	static class Node {
		Node[] child = new Node[26];
		int count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		root = new Node();
		map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			// 트라이에 넣으면서 최단 유일 접두사 찾기
			String unique = insertAndGetPrefix(str);

			// 이름 카운팅 확인
			int cnt = map.getOrDefault(str, 1);

			if (cnt == 1) {
				bw.write(unique + '\n');
			} else {
				bw.write(str + cnt + '\n');
			}
			map.put(str, cnt + 1);
		}

		bw.flush();
		bw.close();
	}

	// 트라이에 name 넣으면서 유일하게 구분하게 해주는 가장 짧은 접두사 리턴.
	static String insertAndGetPrefix(String name) {
		Node node = root;
		String answer = null;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			int idx = c - 'a';

			if (node.child[idx] == null) {
				node.child[idx] = new Node();
			}

			node = node.child[idx];
			node.count++;
			sb.append(c);

			if (node.count == 1 && answer == null) {
				answer = sb.toString();
			}
		}

		// 끝까지 왔는데 count가 1인 지점이 없다면, 전체 이름이 곧 유일한 접두사라는 것!
		if (answer == null) {
			answer = name;
		}
		return answer;
	}

}
