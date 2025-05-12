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

		int N, sum = 0;
		List<Integer> list = new ArrayList<>();

		while (true) {
			N = Integer.parseInt(br.readLine());

			if (N == -1)
				break;

			for (int i = 1; i <= N / 2; i++) {
				if (N % i == 0) {
					list.add(i);
					sum += i;
				}
			}

			if (sum != N) {
				bw.write(N + " is NOT perfect.\n");
			} else {
				bw.write(N + " = ");
				for (int i = 0; i < list.size(); i++) {
					bw.write(Integer.toString(list.get(i)));
					if (i != list.size() - 1)
						bw.write(" + ");
				}
				bw.newLine();
			}

			list.clear();
			sum = 0;
		}

		bw.flush();
		bw.close();
	}
}