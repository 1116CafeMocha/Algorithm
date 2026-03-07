import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static final int max = 1_000_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] arr = new boolean[max+1];
		arr[0] = true;
		arr[1] = true;
		for(int i=4; i<=max; i+=2) arr[i] = true;
		for(int i=3; i*i<=max; i+=2) {
			if(arr[i]) continue;
			for(int j=i*i; j<=max; j+=i*2) arr[j] = true;
		}
		
		List<Integer> primes = new ArrayList<>();
		
		for(int i=2; i<=max; i++) if(!arr[i]) primes.add(i);
		int size = primes.size();
		
		List<Integer> superPrimes = new ArrayList<>();
		for(int i=0; i<size; i++) {
			int now = primes.get(i) - 1;
			if(now >= size) break;
			superPrimes.add(primes.get(now));
		}
		
		Collections.sort(superPrimes);
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			bw.write(superPrimes.get(N-1)+"\n");
		}
		
		bw.flush();
		bw.close();
	}
	
}