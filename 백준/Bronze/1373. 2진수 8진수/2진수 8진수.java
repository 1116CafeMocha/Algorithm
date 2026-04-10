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
		StringBuilder sb = new StringBuilder();
		
		int len = input.length();
		int first = len % 3;
		
		if(first == 1) sb.append(input.charAt(0) - '0');
		else if (first == 2) sb.append((input.charAt(0) - '0') * 2 + (input.charAt(1) - '0'));
		
		for(int i=first; i<len; i+=3)
			sb.append((input.charAt(i) - '0') * 4 + (input.charAt(i+1) -'0') * 2 + (input.charAt(i+2) - '0'));
		
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}

}