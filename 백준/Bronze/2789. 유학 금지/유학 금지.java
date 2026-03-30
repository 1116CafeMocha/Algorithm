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
		for(int i=0; i<str.length(); i++) {
			input = input.replace(Character.toString(str.charAt(i)), "");
		}
		
		bw.write(input);
		
		bw.flush();
		bw.close();
	}

}