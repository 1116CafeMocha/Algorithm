import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 백준 1351번. 무한 수열

public class Main {
	static HashMap<Long, Long> map = new HashMap<>();
	static Long N, P, Q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input;
		input = br.readLine().split(" ");

		N = Long.parseLong(input[0]);
		P = Long.parseLong(input[1]);
		Q = Long.parseLong(input[2]);

		System.out.println(solve(N));
	}

	public static long solve(Long i) {
		if (i == 0)
			return 1;
		if (map.containsKey(i))
			return map.get(i);

		long result = solve(i / P) + solve(i / Q);
		map.put(i, result);

		return result;
	}

}
