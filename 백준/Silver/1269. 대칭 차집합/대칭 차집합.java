import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);

		Set<String> set = new HashSet<>();

		input = br.readLine().split(" ");
		for (String now : input) {
			set.add(now);
		}

		input = br.readLine().split(" ");
		for (String now : input) {
			if (set.contains(now)) {
				set.remove(now);
			} else {
				set.add(now);
			}
		}

		bw.write(Integer.toString(set.size()));

		bw.flush();
		bw.close();
	}
}
