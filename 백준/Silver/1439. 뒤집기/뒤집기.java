import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		int[] count = new int[2];
		
		count[str.charAt(0)-'0']++;
		
		for(int i=1; i<str.length(); i++) {
			if(str.charAt(i) != str.charAt(i-1)) {
				count[str.charAt(i) - '0']++;
			}
		}
		
		int answer = Math.min(count[0], count[1]);
		
		bw.write(Integer.toString(answer));

		bw.flush();
		bw.close();
	}

}
