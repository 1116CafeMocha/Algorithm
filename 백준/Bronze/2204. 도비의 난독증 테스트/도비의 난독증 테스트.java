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
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;
			
			String[] arr = new String[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = br.readLine();
			}
			
			Arrays.sort(arr, (a, b) -> {
				return a.toLowerCase().compareTo(b.toLowerCase());
			});
			
			bw.write(arr[0] + "\n");
		}
		
		bw.flush();
		bw.close();
	}

}