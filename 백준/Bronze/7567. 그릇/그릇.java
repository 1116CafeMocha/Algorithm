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

		char before = input[0];
		int answer = 10;

		for (int i = 1; i < input.length; i++) {
			char now = input[i];
			if (now == before) {
				answer += 5;
			} else {
				before = now;
				answer += 10;
			}
		}

		bw.write(Integer.toString(answer));

		bw.flush();
		bw.close();
	}
}
