import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		List<Integer> odd = new ArrayList<>();
		List<Integer> even = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			int now = Integer.parseInt(input[i]);
			if (now % 2 == 0)
				even.add(now);
			else
				odd.add(now);
		}

		int answer = 1;
		if (odd.isEmpty()) {
			for (int now : even) {
				answer *= now;
			}
		} else {
			for (int now : odd) {
				answer *= now;
			}
		}

		bw.write(Integer.toString(answer));

		bw.flush();
		bw.close();
	}
}
