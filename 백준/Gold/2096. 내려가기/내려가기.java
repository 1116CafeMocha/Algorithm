import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] dpMax = new int[3];
		int[] dpMin = new int[3];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");

			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			int C = Integer.parseInt(input[2]);

			int[] nextMax = new int[3];
			int[] nextMin = new int[3];

			nextMax[0] = A + Math.max(dpMax[0], dpMax[1]);
			nextMax[1] = B + Math.max(dpMax[0], Math.max(dpMax[1], dpMax[2]));
			nextMax[2] = C + Math.max(dpMax[1], dpMax[2]);

			nextMin[0] = A + Math.min(dpMin[0], dpMin[1]);
			nextMin[1] = B + Math.min(dpMin[0], Math.min(dpMin[1], dpMin[2]));
			nextMin[2] = C + Math.min(dpMin[1], dpMin[2]);

			dpMax = nextMax;
			dpMin = nextMin;
		}

		int MAX = Math.max(dpMax[0], Math.max(dpMax[1], dpMax[2]));
		int MIN = Math.min(dpMin[0], Math.min(dpMin[1], dpMin[2]));

		bw.write(MAX + " " + MIN);

		bw.flush();
		bw.close();
	}

}
