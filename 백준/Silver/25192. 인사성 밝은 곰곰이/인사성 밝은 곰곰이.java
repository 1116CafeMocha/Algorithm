import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int count = 0;
		boolean flag = false;

		HashSet<String> set = new HashSet<>();

		while (N-- > 0) {
			String input = br.readLine();

			if (input.equals("ENTER")) {
				set.clear();
				flag = true;
				continue;
			}

			if (!flag)
				continue;

			if (!set.contains(input)) {
				count++;
				set.add(input);
			}
		}

		bw.write(Integer.toString(count));

		bw.flush();
		bw.close();
	}
}
