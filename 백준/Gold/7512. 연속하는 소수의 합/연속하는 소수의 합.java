import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 10_000_000;
	static boolean[] isPrime;
	static int[] primes;
	
	static class State {
		int len;
		int start;
		long sum;
		
		State(int len){
			this.len = len;
			this.start = 0;
			this.sum = 0;
			for(int i=0; i<len; i++) {
				this.sum += primes[i];
			}
		}
		
		void slideOnce() {
			sum -= primes[start];
			sum += primes[start + len];
			start++;
		}
		
		void toLeastPrime(long target) {
			while(true) {
				if (sum >= MAX) return;
				if(sum >= target && isPrime[(int)sum]) return;
				slideOnce();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		int T = Integer.parseInt(br.readLine());
		
		mkSosu(MAX);
		
		for(int t=1; t<=T; t++) {
			int M = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			State[] arr = new State[M];
			for(int i=0; i<M; i++) {
				arr[i] = new State(Integer.parseInt(st.nextToken()));				
			}
			
			long answer = solve(arr);
			
			bw.write("Scenario " + t + ":\n");
			bw.write(answer + "\n\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static long solve(State[] states) {
		for(State st : states) {
			st.toLeastPrime(2);
		}
		
		while(true) {
			long maxVal = Long.MIN_VALUE;
			
			for(State st : states) {
				if(st.sum > maxVal) maxVal = st.sum;
			}
			
			boolean allSame = true;
			
			for(State st : states) {
				if(st.sum != maxVal) {
					allSame = false;
					st.toLeastPrime(maxVal);
				}
			}
			
			if(allSame) return maxVal;
		}
	}
	
	static void mkSosu(int N) {
		isPrime = new boolean[N];
		Arrays.fill(isPrime, true);
		
		if(N>0) isPrime[0] = false;
		if(N>1) isPrime[1] = false;
		
		for(int i=1; (long)i*i<N; i++) {
			if(isPrime[i]) {
				for(int j=i*i; j<N; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		int count = 0;
		for(int i=2; i<N; i++) {
			if(isPrime[i]) count++;
		}
		
		primes = new int[count];
		int idx = 0;
		for(int i=2; i<N; i++) {
			if(isPrime[i]) primes[idx++] = i;
		}
	}

}