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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		char game = st.nextToken().charAt(0);
		
		int num = game == 'Y' ? 1 : game == 'F' ? 2 : 3;
		
		Set<String> set = new HashSet<>();
		
		while(N-- > 0) {
			set.add(br.readLine());
		}
		
		bw.write(Integer.toString(set.size() / num));
		
		bw.flush();
		bw.close();
	}

}
