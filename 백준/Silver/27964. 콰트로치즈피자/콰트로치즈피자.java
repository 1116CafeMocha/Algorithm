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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Set<String> set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			String now = st.nextToken();
			
			if(now.length() < 6) continue;
			
			int idx = now.length() - 6;
			String com = now.substring(idx);
			if(com.equals("Cheese")) set.add(now);
			
			if(set.size() >= 4) break;
		}
		
		int size = set.size();
		if(size >= 4) bw.write("yummy");
		else bw.write("sad");
		
		bw.flush();
		bw.close();
	}
	
}