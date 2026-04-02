import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		
		boolean[] arr;
		int count = 0;
		
		while(K-- > 0) {
			count = 0;
			
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			arr = new boolean[M+1];
			
			for(int i=0; i<P; i++) {
				int now = Integer.parseInt(br.readLine());
				if(arr[now]) count++;
				else arr[now] = true;
			}
			
			bw.write(count + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
}