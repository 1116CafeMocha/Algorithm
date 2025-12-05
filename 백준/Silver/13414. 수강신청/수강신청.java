import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		LinkedHashSet<String> set = new LinkedHashSet<>();

		for (int i = 0; i < L; i++) {
			String now = br.readLine();
			set.remove(now);
			set.add(now);
		}

		int idx = 0;
		for (String now : set) {
			if (idx >= K)
				break;

			bw.write(now);
			bw.newLine();

			idx++;
		}

		bw.flush();
		bw.close();
	}

}
