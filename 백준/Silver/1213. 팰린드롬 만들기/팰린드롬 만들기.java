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
		int len = str.length();
		
		int[] arr = new int[26];
		for(int i=0; i<len; i++) {
			arr[str.charAt(i) - 'A']++;
		}
		
		int count = 0;
		int mid = -1;
		
		for(int i=0; i<26; i++) {
			if(arr[i] % 2 != 0) {
				count++;
				mid = i;
			} 
		}
		
		if(count > 1) bw.write("I'm Sorry Hansoo");
		else {
			String left = "";
			for(int i=0; i<26; i++) {
				for(int j=0; j<arr[i]/2; j++) {
					left += (char)(i + 'A');
				}
			}
			
			bw.write(left);
			
			if(mid != -1) bw.write((char) mid + 'A');
			
			for(int i=left.length()-1; i>=0; i--) bw.write(left.charAt(i));
		}
		
		bw.flush();
		bw.close();
	}

}