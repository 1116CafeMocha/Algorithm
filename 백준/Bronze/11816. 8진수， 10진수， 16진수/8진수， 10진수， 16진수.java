import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int X = 0;
		String input = br.readLine();
		if(input.charAt(1)=='x') X = Integer.parseInt(input.substring(2,input.length()), 16);
		else if(input.charAt(0)=='0') X = Integer.parseInt(input, 8);
		else X = Integer.parseInt(input);
		
		bw.write(Integer.toString(X));
		
		bw.flush();
		bw.close();
	}

}