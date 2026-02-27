import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static final int N = 10_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(br.readLine());
		
		boolean[] prime = new boolean[N+1];
		
		prime[0] = true;
		prime[1] = true;
		
		if(K == 1) {
			bw.write("2");
			bw.flush();
			return;
		}
		
		for(int i=3; i <= (int)Math.sqrt(N); i+=2) {
			if(prime[i]) continue;
			for(int j=i*i; j<=N; j+=i*2) prime[j] = true;
		}
		
		int count = 1;
		for(int i=3; i<= N; i+=2) {
			if(prime[i]) continue;
			
			count++;
			
			if(count == K) {
				bw.write(Integer.toString(i));
				break;
			}
		}
		
		bw.flush();
		bw.close();
	}

}