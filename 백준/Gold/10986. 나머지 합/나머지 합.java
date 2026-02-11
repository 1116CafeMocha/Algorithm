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
		
		long[] count = new long[M];
		count[0] = 1;
		
		long sum = 0;
		
		for(int i=0; i<N; i++) {
			sum += Long.parseLong(st.nextToken());
			int val = (int)(sum % M);
			count[val]++;
		}
		
		long answer = 0;
		
		for(int i=0; i<M; i++) {
			long now = count[i];
			answer += now * (now-1) / 2;
		}
		
		bw.write(Long.toString(answer));
		
		bw.flush();
		bw.close();
	}
}