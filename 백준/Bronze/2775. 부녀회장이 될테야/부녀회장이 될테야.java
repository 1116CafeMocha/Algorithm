import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[15][15];
		
		for(int i=0; i<15; i++) {
			dp[0][i] = i;
		}
		
		for(int r=1; r<15; r++) {
			for(int c=1; c<15; c++) {
				dp[r][c] = dp[r-1][c] + dp[r][c-1];
			}
		}
		
		for(int i=0; i<T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			bw.write(dp[k][n]+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}