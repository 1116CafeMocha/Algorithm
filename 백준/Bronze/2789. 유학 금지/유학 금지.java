import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		
		String str = "CAMBRIDGE";
		
		for(int i=0; i<input.length(); i++) {
			char now = input.charAt(i);
			if(str.indexOf(now) == -1) bw.write(now);
		}
		
		bw.flush();
		bw.close();
	}

}