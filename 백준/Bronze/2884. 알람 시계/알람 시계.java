import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;

		input = br.readLine().split(" ");
		int H = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		int sum = H * 60 + M - 45;
		if (sum < 0)
			sum += 24 * 60;
		bw.write(sum / 60 + " " + sum % 60);

		bw.flush();
		bw.close();
	}

}
