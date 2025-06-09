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

		String[] input;
		int N = Integer.parseInt(br.readLine());

		Set<String> set = new TreeSet<>();

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			if (input[1].equals("enter")) {
				set.add(input[0]);
			} else {
				set.remove(input[0]);
			}
		}

		Object[] ary = set.toArray();

		for (int i = ary.length - 1; i >= 0; i--) {
			bw.write(ary[i].toString());
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}
