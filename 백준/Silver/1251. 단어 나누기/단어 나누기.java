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
		int len = input.length();
		String answer = null;

		for (int i = 1; i <= len - 2; i++) {
			for (int j = i + 1; j <= len - 1; j++) {
				String a = new StringBuilder(input.substring(0, i)).reverse().toString();
				String b = new StringBuilder(input.substring(i, j)).reverse().toString();
				String c = new StringBuilder(input.substring(j)).reverse().toString();

				String candidate = a + b + c;

				if (answer == null || candidate.compareTo(answer) < 0) {
					answer = candidate;
				}
			}
		}
		
		bw.write(answer);
		
		bw.flush();
		bw.close();
	}

}
