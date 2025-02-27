import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 백준 10816번 숫자 카드 2
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		HashMap<String, Integer> map = new HashMap<>();

		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			map.put(input[i], map.getOrDefault(input[i], 0) + 1);
		}

		int M = Integer.parseInt(br.readLine());

		input = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			if (map.containsKey(input[i]))
				sb.append(map.get(input[i]) + " ");
			else
				sb.append("0 ");
		}

		System.out.println(sb);

	}

}
