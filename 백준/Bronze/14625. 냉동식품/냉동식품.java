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
		int[] start = { Integer.parseInt(input[0]), Integer.parseInt(input[1]) };
		input = br.readLine().split(" ");
		int[] end = { Integer.parseInt(input[0]), Integer.parseInt(input[1]) };
		int N = Integer.parseInt(br.readLine());

		int count = 0;

		while (true) {
			String str = String.format("%02d%02d", start[0], start[1]);
			char[] arr = str.toCharArray();
			boolean hit = false;
			for (int i = 0; i < 4; i++) {
				if (str.charAt(i) == ('0' + N)) {
					hit = true;
					break;
				}
			}
			if (hit)
				count++;

			if (start[0] == end[0] && start[1] == end[1])
				break;

			start[1]++;

			if (start[1] >= 60) {
				start[1] = 0;
				start[0]++;
			}
		}

		bw.write(Integer.toString(count));

		bw.flush();
		bw.close();
	}
}
