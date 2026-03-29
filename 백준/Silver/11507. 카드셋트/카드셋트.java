import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		
		int[] count = new int[4]; // P, K, H, T
		Set<String> set = new HashSet<>();
		
		for(int i=0; i<input.length(); i+=3) {
			String now = input.substring(i, i+3);
			
			if(set.contains(now)) {
				System.out.println("GRESKA");
				return;
			} else {
				set.add(now);
			}
			
			char shape = now.charAt(0);
			if(shape == 'P') count[0]++;
			else if(shape == 'K') count[1]++;
			else if(shape == 'H') count[2]++;
			else count[3]++;
		}
		
		for(int now : count) bw.write(13 - now + " ");

		bw.flush();
		bw.close();
	}

}