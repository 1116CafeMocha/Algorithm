import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[M];
		
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int maxCost = 0;
		int maxVal = 0;
		
		for(int i=M-1; i>=0; i--) {
			if(M-i > N) break;
			int now = (M-i) * arr[i];
			if(now >= maxVal) {
				maxCost = arr[i];
				maxVal = now;
			}
		}
		
		bw.write(maxCost + " " + maxVal);
		
		bw.flush();
		bw.close();
	}

}