import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		int[] count = new int[26];

		for (char now : input.toCharArray()) {
			count[(int) now - 97]++;
		}

		for (int now : count) {
			bw.write(now + " ");
		}

		bw.flush();
		bw.close();
	}

}
