import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = br.readLine();
			if(input == null) break;
			sb.append(input);
		}
		
		StringTokenizer st = new StringTokenizer(sb.toString(), ",");
		int N = st.countTokens();
		Long sum = 0L;
		for(int i=0; i<N; i++) sum += Integer.parseInt(st.nextToken());
		bw.write(Long.toString(sum));
		
		bw.flush();
		bw.close();
	}

}