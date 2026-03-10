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
		
		int P = Integer.parseInt(br.readLine());
		while(P-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			bw.write(st.nextToken() + " ");
			int[] arr = new int[20];
			for(int i=0; i<20; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int count = 0;
			for(int i=1; i<20; i++) {
				int now = arr[i];
				int j = i-1;
				
				while(j >= 0 && arr[j] > now) {
					arr[j+1] = arr[j];
					count++;
					j--;
				}
				arr[j+1] = now;
			}
			
			bw.write(count + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
}