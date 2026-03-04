import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] arr = new boolean[246913];
		arr[0] = true;
		arr[1] = true;
		
		for(int i=4; i<246913; i+=2) arr[i] = true;
		
		for(int i=3; i<(int) Math.sqrt(246913); i+=2) {
			if(arr[i]) continue;
			for(int j=i*i; j<246913; j+=i*2) arr[j] = true;
		}
		
		int[] dp = new int[246913];
		
		for(int i=1; i<246913; i++) {
			if(!arr[i]) dp[i] = dp[i-1]+1;
			else dp[i] = dp[i-1];
		}
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			bw.write(dp[2*N] - dp[N] + "\n");
		}
		
		bw.flush();
		bw.close();
	}

}