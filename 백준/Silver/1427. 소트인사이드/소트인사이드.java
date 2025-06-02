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

		char[] input = br.readLine().toCharArray();
		int[] N = new int[input.length];

		for (int i = 0; i < input.length; i++) {
			N[i] = Character.getNumericValue(input[i]);
		}

		Arrays.sort(N);

		for (int i = input.length - 1; i >= 0; i--) {
			bw.write(Integer.toString(N[i]));
		}

		bw.flush();
		bw.close();
	}
}
