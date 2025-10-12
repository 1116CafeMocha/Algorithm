import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] input = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		
		if(N == 1) {
			System.out.println(input[1]);
			return;
		}else if(N == 2) {
			System.out.println(input[1] + input[2]);
			return;
		}
		
		int[] dp = new int[N+1];
		dp[0] = 0;
		dp[1] = input[1];
		dp[2] = input[1] + input[2];
		
		for(int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + input[i], dp[i-3] + input[i-1] + input[i]));
		}
		
		bw.write(Integer.toString(dp[N]));
		
		bw.flush();
		bw.close();
	}
}
