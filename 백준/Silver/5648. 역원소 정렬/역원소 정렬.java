import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = "";
		
		List<Long> list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int size = st.countTokens();
		long N = Long.parseLong(st.nextToken());
		for(int i=1; i<size; i++) {
			list.add(rev(st.nextToken()));
		}
		
		while((input = br.readLine()) != null) {
			st = new StringTokenizer(input);
			
			size = st.countTokens();
			for(int i=0; i<size; i++) {
				list.add(rev(st.nextToken()));
			}
		}
		
		Collections.sort(list);
		
		for(long now : list) bw.write(now + "\n");
		
		bw.flush();
		bw.close();
	}
	
	static Long rev(String x) {
		StringBuffer sb = new StringBuffer(x);
		return Long.parseLong(sb.reverse().toString());
	}
}
