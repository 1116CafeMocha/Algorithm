import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		String N = input[0];
		int B = Integer.parseInt(input[1]);
		
		long result = 0;
		long temp = 1;
		
		for(int i=N.length()-1; i>=0; i--) {
			char now = N.charAt(i);
			int value;
			if((int)now >= 65 && (int)now <= 90) {
				value = (int)now - 55;
			}else {
				value = Character.getNumericValue(now);
			}
			
			result += value * temp;
			temp *= B;
		}
		
		bw.write(Long.toString(result));

		bw.flush();
		bw.close();
	}
}