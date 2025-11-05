import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		long A = Long.parseLong(input[0]);
		long B = Long.parseLong(input[1]);
		
		int size = (int)Math.sqrt(B) + 1;
		
		boolean[] sosu = new boolean[size + 1];
		
		for(int i=2; 1L * i * i <= size; i++) {
			if(sosu[i]) continue;
			
			long idx = 1L * i * i;
			
			while(idx <= size) {
				sosu[(int)idx] = true;
				
				idx+=i;
			}
		}
		
		int count = 0;
		
		for(int i=2; i<=size; i++) {
			if(sosu[i]) continue;
			
			long val = 1L * i * i;
			
			while(val <= B) {
				if(val >= A) count++;
				if (val > B / i) break;
				val *= i;
			}
		}
		
		bw.write(Integer.toString(count));
		
		bw.flush();
		bw.close();
	}

}
