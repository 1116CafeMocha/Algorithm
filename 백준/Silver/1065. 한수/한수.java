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
		
		int count = 0;
		
		for(int i=1; i<= N; i++) {
			if(check(i)) count++;
		}
		
		bw.write(Integer.toString(count));
		
		bw.flush();
		bw.close();
	}
	
	static boolean check(int num) {
		if(num < 100) return true;
		
		int digit0 = num%10;
		num /= 10;
		
		int digit1 = num%10;
		num /= 10;
		
		int val = digit0 - digit1;
		int pre = digit1;
		
		while(num > 0) {
			int digit = num % 10;
			
			if(pre - digit != val) return false;
			
			num /= 10;
		}
		
		return true;
		
	}

}
