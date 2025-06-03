import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		List<int[]> list = new ArrayList<>();

		int N = Integer.parseInt(br.readLine());
		String[] input;
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			list.add(new int[] { Integer.parseInt(input[0]), Integer.parseInt(input[1]) });
		}

		Collections.sort(list, (a, b) -> {
			if (a[0] == b[0])
				return a[1] - b[1];
			return a[0] - b[0];
		});

		for (int[] now : list) {
			bw.write(now[0] + " " + now[1] + "\n");
		}

		bw.flush();
		bw.close();
	}
}
