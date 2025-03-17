import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

// 백준 11723번. 집합

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;
		int x = 0;

		int M = Integer.parseInt(br.readLine().strip());
		TreeSet<Integer> S = new TreeSet<>();

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			if (input.length > 1) {
				x = Integer.parseInt(input[1]);
			}
			switch (input[0]) {
			case "add":
				S.add(x);
				break;
			case "remove":
				S.remove(x);
				break;
			case "check":
				if (S.contains(x)) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
				break;
			case "toggle":
				if (S.contains(x)) {
					S.remove(x);
				} else {
					S.add(x);
				}
				break;
			case "all":
				S.clear();
				for (int k = 1; k <= 20; k++) {
					S.add(k);
				}
				break;
			case "empty":
				S.clear();
				break;
			}
		}
		bw.flush();
		bw.close();
	}

}
