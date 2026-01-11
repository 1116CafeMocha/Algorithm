import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean now = true;
		int count = 0;
		
		for(int r=0; r<8; r++) {
			String input = br.readLine();
			for(int c=0; c<8; c++) {
				if(now) {
					if(c%2!=0) continue;
					if(input.charAt(c) == 'F') count++;
				}else {
					if(c%2==0) continue;
					if(input.charAt(c) == 'F') count++;
				}
			}
			now = !now;
		}
		bw.write(Integer.toString(count));
		
		bw.flush();
		bw.close();
	}
}
