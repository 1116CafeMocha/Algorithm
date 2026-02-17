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
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int time = 0;
		long sum = 0;
		
		for(int i=0; i<L; i++) {
			sum += arr[i];
			
			if(sum >= 129 && sum <= 138) {
				time++;
			}
		}
		
		for(int i=L; i<N; i++) {
			sum += arr[i];
			sum -= arr[i-L];
			
			if(sum >= 129 && sum <= 138) {
				time++;
			}
		}
		
		bw.write(Integer.toString(time));
		
		bw.flush();
		bw.close();
	}

}