// 백준 11659번. 구간 합 구하기 4

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;

		input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");
		int[] sum = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(input[i - 1]);
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int I = Integer.parseInt(input[0]);
			int J = Integer.parseInt(input[1]);

			bw.write(sum[J] - sum[I - 1] + "\n");
		}

		bw.flush();
		bw.close();
	}

}
