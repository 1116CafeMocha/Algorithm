import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 소수 판별을 위해 먼저 에라토스테네스의 체로 소수 목록을 만들어야 하는 거 아닌가? 
// => 조건을 만족하는 후보만 dfs로 확인하는 거라서, 
// 그냥 매번 N^1/2(루트N) 까지 나눠보면서 확인해도 됨.

public class Main {
	static BufferedWriter bw;
	static int N;
	// 뒤에 올 수 있는 숫자 후보들
	static int[] arr = {1, 3, 7, 9};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		int[] arr = {2, 3, 5, 7};
		for(int now : arr) dfs(now, 1);
		
		bw.flush();
		bw.close();
	}
	
	static void dfs(int num, int depth) throws IOException {
		if(depth == N) {
			bw.write(num + "\n");
			return;
		}
		
		for(int now : arr) {
			int next = num * 10 + now;
			if(isPrime(next)) dfs(next, depth+1);
		}
		
	}
	
	// 소수 확인
	static boolean isPrime(int num) {
		if(num < 2) return false;
		if(num == 2) return true;
		// 짝수 제거
		if(num % 2 == 0) return false;
		
		// 루트N까지 확인 (위에서 짝수 제거해서 홀수만 보면 됨)
		for(int i=3; i*i <= num; i+=2) {
			if(num % i == 0) return false;
		}
		return true;
	}
	
}