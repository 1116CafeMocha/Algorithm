import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static final int max = 100_000_000;
	
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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		for(int i=A; i<=B; i++) {
			if(arr[i]) continue;
			if(!check(i)) continue;
			bw.write(i + "\n");
		}
		
		bw.write("-1");
		
		bw.flush();
		bw.close();
	}
	
	static boolean check(int N) {
		char[] str = Integer.toString(N).toCharArray();
		for(int i=0; i<str.length/2; i++) {
			int j = str.length - 1 - i;
			
			if(str[i] != str[j]) return false;
		}
		return true;
	}
}