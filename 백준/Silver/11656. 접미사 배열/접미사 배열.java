import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] input = br.readLine().toCharArray();
		Set<String> set = new TreeSet<>();

		String temp = Character.toString(input[input.length - 1]);
		set.add(temp);

		for (int i = input.length - 2; i >= 0; i--) {
			temp = input[i] + temp;
			set.add(temp);
		}

		for (String now : set) {
			bw.write(now);
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}
