import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

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
		
		List<Integer> list = new ArrayList<>();
		
		while(num > 0) {
			int digit = num % 10;
			list.add(digit);
			num /= 10;
		}
		
		int val = list.get(1) - list.get(0);
		
		for(int i=2; i<list.size(); i++) {
			if(list.get(i) - list.get(i-1) != val) return false;
		}
		
		return true;
		
	}

}
