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
		
		int N = Integer.parseInt(br.readLine());
		int[] tips = new int[N];
		for(int i=0; i<N; i++) tips[i] = Integer.parseInt(br.readLine());
		Arrays.sort(tips);
		
		long sum = 0;
		
		for(int i=N-1; i>=0; i--) {
			int tip = tips[i] - (N - i - 1);
			if(tip <= 0) continue;
			sum += tip;
		}
		
		bw.write(Long.toString(sum));
		
		bw.flush();
		bw.close();
	}

}