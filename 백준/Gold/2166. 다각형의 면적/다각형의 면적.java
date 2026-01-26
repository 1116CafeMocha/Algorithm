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
		
		int N = Integer.parseInt(br.readLine());
		
		long[] X = new long[N];
		long[] Y = new long[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			X[i] = Long.parseLong(st.nextToken());
			Y[i] = Long.parseLong(st.nextToken());
		}
		
		long sum = 0;
		for(int i=0; i<N; i++) {
			int next = i+1;
			if(i==N-1) next = 0;
			
			sum += X[i] * Y[next] - X[next] * Y[i];
		}
		
		double answer = Math.abs(sum) / 2.0;
		
		bw.write(String.format("%.1f", answer));
		
		bw.flush();
		bw.close();
	}
}
