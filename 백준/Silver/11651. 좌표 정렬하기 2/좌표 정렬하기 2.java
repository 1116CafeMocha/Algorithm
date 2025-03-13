// 백준 11651번. 좌표 정렬하기 2

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;

		int N = Integer.parseInt(br.readLine());
		int[][] array = new int[N][2];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");

			array[i][0] = Integer.parseInt(input[0]); // x
			array[i][1] = Integer.parseInt(input[1]); // y
		}

		Arrays.sort(array, (a, b) -> {
			if (a[1] == b[1])
				return a[0] - b[0]; // x 오름차순
			return a[1] - b[1]; // y 오름차순
		});

		for (int i = 0; i < N; i++) {
			bw.write(array[i][0] + " " + array[i][1] + "\n");
		}

		bw.flush();
		bw.close();
	}

}
