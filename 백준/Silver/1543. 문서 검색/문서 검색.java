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
		String target = br.readLine();

		int idx = 0, count = 0;

		while ((idx = input.indexOf(target, idx)) != -1) {
			count++;
			idx += target.length();
		}

		bw.write(Integer.toString(count));

		bw.flush();
		bw.close();
	}
}
