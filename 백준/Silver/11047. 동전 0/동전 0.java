import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		int[] coins = new int[N];
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			coins[N-1-i] = Integer.parseInt(br.readLine().strip());
		}
		
		for(int i=0; i<N; i++) {
			if(K/coins[i] == 0) continue;
			
			answer += K/coins[i];
			K = K % coins[i];
			
			if(K==0) break;
		}
		
		System.out.println(answer);
	}

}