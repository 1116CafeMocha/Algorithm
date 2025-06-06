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

		int N = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(input[i]));
		}

		int M = Integer.parseInt(br.readLine());

		input = br.readLine().split(" ");

		for (String now : input) {
			if (set.contains(Integer.parseInt(now))) {
				bw.write("1 ");
			} else {
				bw.write("0 ");
			}
		}

		bw.flush();
		bw.close();
	}
}
