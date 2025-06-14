// 백준 2866번. 문자열 잘라내기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static int R, C;
	static String[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);

		arr = new String[R][C];

		for (int r = 0; r < R; r++) {
			char[] charArr = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				arr[r][c] = Character.toString(charArr[c]);
			}
		}

		int low = 0;
		int high = R - 1;
		int answer = 0;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (check(mid)) {
				answer = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		bw.write(Integer.toString(answer));

		bw.flush();
		bw.close();
	}

	static boolean check(int idx) {
		Set<String> set = new HashSet<>();

		for (int c = 0; c < C; c++) {
			StringBuilder sb = new StringBuilder();
			for (int r = idx; r < R; r++) {
				sb.append(arr[r][c]);
			}
			if (!set.add(sb.toString()))
				return false;
		}
		return true;
	}
}
