import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(br.readLine().strip());
		int[] count = new int[X + 1];

		count[0] = count[1] = 0;

		for (int i = 2; i < X + 1; i++) {
			count[i] = count[i - 1] + 1;
			if (i % 2 == 0)
				count[i] = Math.min(count[i], count[i / 2] + 1);
			if (i % 3 == 0)
				count[i] = Math.min(count[i], count[i / 3] + 1);
		}

		System.out.println(count[X]);

	}

}