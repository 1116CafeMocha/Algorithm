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
		char[] arr = br.readLine().toCharArray();
		
		for(int i=0; i<N-1; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<arr.length; j++) {
				if(arr[j] != temp[j]) arr[j] = '?';
			}
		}
		
		for(char now : arr) bw.write(now);
		
		bw.flush();
		bw.close();
	}
}