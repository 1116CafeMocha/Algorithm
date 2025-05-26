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

		int[] ary = new int[5];

		int sum = 0;

		for (int i = 0; i < 5; i++) {
			int now = Integer.parseInt(br.readLine());
			ary[i] = now;
			sum += now;
		}

		Arrays.sort(ary);

		bw.write(Integer.toString(sum / 5));
		bw.newLine();
		bw.write(Integer.toString(ary[2]));

		bw.flush();
		bw.close();
	}
}
