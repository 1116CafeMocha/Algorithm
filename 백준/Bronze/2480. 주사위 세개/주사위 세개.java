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

		int[] dice = new int[7];
		int count = 0;
		int equal = 0;
		int max = 0;

		input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		int C = Integer.parseInt(input[2]);

		dice[A]++;
		dice[B]++;
		dice[C]++;

		for (int i = 1; i <= 6; i++) {
			if (dice[i] > count)
				count = dice[i];
			if (dice[i] >= 2)
				equal = i;
			if (dice[i] != 0)
				max = i;
		}

		if (count == 3) {
			bw.write(10000 + equal * 1000 + "");
		} else if (count == 2) {
			bw.write(1000 + equal * 100 + "");
		} else {
			bw.write(max * 100 + "");
		}

		bw.flush();
		bw.close();
	}

}
