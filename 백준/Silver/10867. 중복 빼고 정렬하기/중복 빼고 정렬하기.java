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

		int N = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");
		Set<Integer> set = new TreeSet<>();

		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(input[i]);
			set.add(now);
		}

		for (int now : set) {
			bw.write(now + " ");
		}

		bw.flush();
		bw.close();
	}

}
