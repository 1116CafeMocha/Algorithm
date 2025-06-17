import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	static int R, C;
	static String[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		Arrays.sort(arr);

		int maxFreq = 0;
		for (int val : map.values()) {
			maxFreq = Math.max(maxFreq, val);
		}

		List<Integer> modeList = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == maxFreq) {
				modeList.add(entry.getKey());
			}
		}
		Collections.sort(modeList);
		int most = (modeList.size() > 1) ? modeList.get(1) : modeList.get(0);

		bw.write(Math.round((double) sum / N) + "\n");
		bw.write(arr[N / 2] + "\n");
		bw.write(most + "\n");
		bw.write(arr[N - 1] - arr[0] + "\n");

		bw.flush();
		bw.close();
	}
}
