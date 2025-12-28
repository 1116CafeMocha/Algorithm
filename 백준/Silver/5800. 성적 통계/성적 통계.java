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
		
		int K = Integer.parseInt(br.readLine());
		
		for(int k=1; k<=K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int MAX = 0;
			int MIN = Integer.MAX_VALUE;
			int GAP = 0;
			
			int[] arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			MAX = arr[N-1];
			MIN = arr[0];
			for(int i=1; i<N; i++) {
				GAP = Math.max(GAP, arr[i]-arr[i-1]);
			}
			
			bw.write("Class " + k);
			bw.newLine();
			bw.write("Max " + MAX + ", " + "Min " + MIN + ", " + "Largest gap " + GAP);
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}
	
}
