import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] input = br.readLine().toCharArray();

		int[] count = new int[10];

		long sum = 0;

		for (char now : input) {
			int val = Character.getNumericValue(now);
			count[val]++;
			sum += val;
		}

		if (count[0] == 0 || sum % 3 != 0) {
			bw.write("-1");
		} else {
			for (int i = 9; i >= 0; i--) {
				for (int j = 0; j < count[i]; j++) {
					bw.write(Integer.toString(i));
				}
			}
		}

		bw.flush();
		bw.close();
	}

}
