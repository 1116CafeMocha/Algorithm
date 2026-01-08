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
		
		bw.write(Integer.toString(rev(rev(Integer.parseInt(st.nextToken())) + rev(Integer.parseInt(st.nextToken())))));
		
		bw.flush();
		bw.close();
	}
	
	static int rev(int x) {
		StringBuffer sb = new StringBuffer(Integer.toString(x));
		return Integer.parseInt(sb.reverse().toString());
	}
}
