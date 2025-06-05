// 1차 시도 : set + list 사용. => list.indexOf 사용으로 인해 시간 초과.
// 2차 시도 : int + map 사용

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] originalArray = new int[N];
		int[] copiedArray;

		String[] input = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			originalArray[i] = Integer.parseInt(input[i]);
		}

		copiedArray = originalArray.clone();
		Arrays.sort(copiedArray);

		Map<Integer, Integer> map = new HashMap<>();

		int idx = 0;

		for (int now : copiedArray) {
			if (!map.containsKey(now)) {
				map.put(now, idx);
				idx++;
			}
		}

		for (int now : originalArray) {
			bw.write(map.get(now) + " ");
		}

		bw.flush();
		bw.close();
	}
}
