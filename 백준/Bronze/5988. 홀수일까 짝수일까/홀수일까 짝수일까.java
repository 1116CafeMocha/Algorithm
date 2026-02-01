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
		while(N-- > 0) {
			String input = br.readLine();
			int num = Character.getNumericValue((input.charAt(input.length()-1)));
			if(num%2==0) bw.write("even\n");
			else bw.write("odd\n");
		}
		
		bw.flush();
		bw.close();
	}
}
