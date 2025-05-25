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

		String[] input = br.readLine().split(" ");

		int[] length = new int[3];

		length[0] = Integer.parseInt(input[0]);
		length[1] = Integer.parseInt(input[1]);
		length[2] = Integer.parseInt(input[2]);

		Arrays.sort(length);
		int sum = length[0] + length[1];
		int max = length[2];

		if (sum > max) {
			bw.write(Integer.toString(sum + max));
		} else {
			bw.write(Integer.toString(sum + sum - 1));
		}

		bw.flush();
		bw.close();
	}
}
