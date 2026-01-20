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
		char grade = input.charAt(0);
		if(grade == 'F') {System.out.println("0.0"); return;}
		char sign = input.charAt(1);
		
		
		double val = 0;
		if(sign == '+') val = 0.3;
		else if(sign == '-') val = -0.3;
		
		double answer = 0.0;
		if (grade == 'A') {
			answer = 4;
		} else if (grade == 'B') {
			answer = 3;
		} else if (grade == 'C') {
			answer = 2;
		} else {
			answer = 1;
		}
		
		bw.write(String.format("%.1f", answer + val));

		bw.flush();
		bw.close();
	}
}
