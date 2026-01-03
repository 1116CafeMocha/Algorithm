import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		Set<String> set = new HashSet<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			set.add(st.nextToken());

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i < N; i++)
			set.remove(st.nextToken());
		
		for(String now : set) {
			bw.write(now);
		}

		bw.flush();
		bw.close();
	}

}
