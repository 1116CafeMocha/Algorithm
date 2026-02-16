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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long sum = 0;
		for(int i=0; i<M; i++) {
			sum += arr[i];
		}
		
		long MAX = sum;
		
		for(int i=M; i<N; i++) {
			sum += arr[i];
			sum -= arr[i-M];
			
			MAX = Math.max(MAX, sum);
		}
		
		bw.write(Long.toString(MAX));
		
		bw.flush();
		bw.close();
	}

}