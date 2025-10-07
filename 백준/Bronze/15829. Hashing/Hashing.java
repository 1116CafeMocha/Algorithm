import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int L = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		
		long val = 0;
		
		for(int i=0; i<L; i++) {
			val += (input[i] - 'a' + 1) * ((long) Math.pow(31, i));
		}
		
		bw.write(Long.toString(val % 1234567891));
		
		bw.flush();
		bw.close();
	}

}
