import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] arr = br.readLine().toCharArray();
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = decode(arr[i]);
		}
		
		for(char now : arr) bw.write(now);
		
		bw.flush();
		bw.close();
	}
	
	static char decode (char C) {
		char temp;
		if(C <= 'C') {
			temp = (char)(C - 3 + ('Z'-'A'+1));
		}
		else temp = (char)(C - 3);
		return temp;
	}
}
