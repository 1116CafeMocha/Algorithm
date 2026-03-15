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
		String str = br.readLine();
		
		int cup = 1;
		int man = 0;
		
		for(int i=0; i<str.length(); i++) {
			char now = str.charAt(i);
			if(now == 'S') {
				cup++;
				man++;
			} else {
				cup++;
				man+=2;
				i++;
			}
		}
		
		if(cup > man) bw.write(Integer.toString(man));
		else bw.write(Integer.toString(cup));
		
		bw.flush();
		bw.close();
	}
	
}