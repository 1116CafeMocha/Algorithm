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
		
		String[] str = new String[N];
		boolean[] check = new boolean[N];
		
		for(int i=0; i<N; i++) {
			str[i] = br.readLine();
		}
		
		int count = 0;
		for(int i=0; i<N; i++) {
			boolean flag = false;
			String strDouble = str[i] + str[i];
			
			if(check[i]) continue;
			
			for(int j=0; j<N; j++) {
				if(check[j]) continue;
				if(str[i].length() != str[j].length()) continue;
				if(strDouble.contains(str[j])) {
					check[j] = true;
					flag = true;
				} 
			}
			if(flag) count++;
		}
		
		bw.write(Integer.toString(count));
		
		bw.flush();
		bw.close();
	}
}