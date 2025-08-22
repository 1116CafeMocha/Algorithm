import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if (N < 2) {
			System.out.println(0);
			return;
		}

		boolean[] arr = new boolean[N + 1];
		arr[0] = true;
		arr[1] = true;

		for (int i = 2; i * i <= N; i++) {
			if (arr[i])
				continue;

			for (int j = i * i; j <= N; j += i) {
				arr[j] = true;
			}
		}

		List<Integer> list = new ArrayList<>();

		for (int i = 2; i <= N; i++) {
			if (!arr[i]) {
				list.add(i);
			}
		}

		int left = 0;
		int right = 0;
		long sum = 0;
		int count = 0;

		while (true) {
			if (sum >= N) {
				if (sum == N) {
					count++;
				}
				sum -= list.get(left);
				left++;
			} else {
				if (right == list.size()) {
					break;
				}

				sum += list.get(right);
				right++;
			}
		}

		System.out.println(count);
	}
}
