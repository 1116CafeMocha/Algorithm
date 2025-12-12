import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split("-");
		String[] first = input[0].split("\\+");
		
		int sumFirst = 0;
		
		for(String now : first) {
			sumFirst += Integer.parseInt(now);
		}
		
		int val = 0;
		
		for(int i=1; i<input.length; i++) {
			String[] temp = input[i].split("\\+");
			
			int sum = 0;
			for(String now : temp) {
				sum += Integer.parseInt(now);
			}
			
			val += sum;
		}
		
		bw.write(Integer.toString(sumFirst - val));
		
		bw.flush();
		bw.close();
	}

}
