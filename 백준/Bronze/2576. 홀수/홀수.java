import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int sum = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < 7; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input % 2 == 0)
				continue;
			min = Math.min(min, input);
			sum += input;
		}

		if (min == Integer.MAX_VALUE)
			bw.write("-1");
		else {
			bw.write(Integer.toString(sum));
			bw.newLine();
			bw.write(Integer.toString(min));
		}

		bw.flush();
		bw.close();
	}
}
