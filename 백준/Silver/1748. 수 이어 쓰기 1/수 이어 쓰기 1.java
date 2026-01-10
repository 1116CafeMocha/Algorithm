import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long N = Long.parseLong(br.readLine());
		
		long ans = 0;
		long start = 1;
		long len = 1;
		
		while(start <= N) {
			long end = start * 10 - 1;
			long last = Math.min(N, end);
			long count = last - start + 1;
			
			ans += count * len;
			
			start *= 10;
			len++;
		}
		
		bw.write(Long.toString(ans));
		
		bw.flush();
		bw.close();
	}
}
