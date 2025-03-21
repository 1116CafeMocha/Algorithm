import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준  18110번. solved.ac

import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int rounded = Math.round(N * 0.15f);

		int[] dif = new int[N];

		for (int i = 0; i < N; i++) {
			dif[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(dif);
		for (int i = rounded; i < N - rounded; i++) {
			sum += dif[i];
		}
		System.out.println(Math.round((float) sum / (float) (N - 2 * rounded)));
	}

}
