import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = br.readLine();
			if(input == null) break;
			sb.append(input);
		}
		
		String[] arr = sb.toString().split(",");
		Long sum = 0L;
		for(String now : arr) sum += Integer.parseInt(now);
		bw.write(Long.toString(sum));
		
		bw.flush();
		bw.close();
	}

}