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
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(N-- > 0) {
			String input = br.readLine();
			input += input;
			if(input.contains(str)) {
				count++;
				continue;
			}
		}
		
		bw.write(Integer.toString(count));
		
		bw.flush();
		bw.close();
	}
}
