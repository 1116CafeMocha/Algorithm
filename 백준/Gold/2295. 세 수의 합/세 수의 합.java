// 백준 2295번. 세 수의 합

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		List<Integer> sum = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				sum.add(arr[i] + arr[j]);
			}
		}

		Collections.sort(sum);

		loop: for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				int now = arr[i] - arr[j];
				if (Collections.binarySearch(sum, now) >= 0) {
					bw.write(Integer.toString(arr[i]));
					break loop;
				}
			}
		}

		bw.flush();
		bw.close();
	}
}
