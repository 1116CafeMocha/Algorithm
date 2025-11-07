import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static class Pair {
		int value, idx;

		Pair(int value, int idx) {
			this.value = value;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		Pair[] arr = new Pair[N];

		for (int i = 0; i < N; i++) {
			arr[i] = new Pair(Integer.parseInt(input[i]), i);
		}

		Arrays.sort(arr, (a, b) -> Integer.compare(a.value, b.value));

		int[] P = new int[N];

		for (int i = 0; i < N; i++) {
			P[arr[i].idx] = i;
		}

		for (int i = 0; i < N; i++) {
			bw.write(P[i] + " ");
		}

		bw.flush();
		bw.close();
	}

}
