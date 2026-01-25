import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int t = input.indexOf('*');
		String patternA = input.substring(0, t);
		String patternB = input.substring(t+1);
		
		while(N-- > 0) {
			String str = br.readLine();
			if(str.length() < patternA.length() + patternB.length()) {bw.write("NE\n"); continue;}
			if(str.startsWith(patternA) && str.endsWith(patternB)) {bw.write("DA\n"); continue;}
			bw.write("NE\n");
		}
		
		bw.flush();
		bw.close();
	}
}
