import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			int countLower = 0;
			int countUpper = 0;
			int countNum = 0;
			int countBlank = 0;
			
			String input = br.readLine();
			
			if(input == null) break;
			for(int i=0; i<input.length(); i++) {
				char now = input.charAt(i);
				if(now == ' ') countBlank++;
				else if(!Character.isAlphabetic(now)) countNum++;
				else if(Character.isLowerCase(now)) countLower++;
				else countUpper++;
			}
			bw.write(countLower + " " + countUpper + " " + countNum + " " + countBlank + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}