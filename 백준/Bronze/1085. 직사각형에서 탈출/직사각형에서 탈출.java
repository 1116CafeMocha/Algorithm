import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int X = Integer.parseInt(input[0]);
		int Y = Integer.parseInt(input[1]);
		int W = Integer.parseInt(input[2]);
		int H = Integer.parseInt(input[3]);

		int min = Integer.MAX_VALUE;

		if (X < min)
			min = X;
		if (Y < min)
			min = Y;
		if (W - X < min)
			min = W - X;
		if (H - Y < min)
			min = H - Y;

		bw.write(Integer.toString(min));

		bw.flush();
		bw.close();
	}
}