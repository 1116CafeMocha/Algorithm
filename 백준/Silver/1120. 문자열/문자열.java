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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		int lenA = A.length();
		int lenB = B.length();
		
		int MIN = Integer.MAX_VALUE;
		
		for(int i=0; i<=lenB - lenA; i++) {
			int count = 0;
			for(int j=i; j<lenA+i; j++) {
				if(A.charAt(j-i) != B.charAt(j)) count++;
			}
			MIN = Math.min(MIN, count);
		}
		
		bw.write(Integer.toString(MIN));
		
		bw.flush();
		bw.close();
	}

}
