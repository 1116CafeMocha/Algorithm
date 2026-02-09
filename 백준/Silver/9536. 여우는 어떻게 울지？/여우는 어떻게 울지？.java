import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String[] arr = br.readLine().split(" ");
			
			while(true) {
				String input = br.readLine();
				if(input.equals("what does the fox say?")) break;
				String[] inputArr = input.split(" ");
				for(int i=0; i<arr.length; i++) {
					if(arr[i].equals(inputArr[2])) arr[i] = "";
				}
			}
			for(String now : arr) {
				if(now.equals("")) continue;
				bw.write(now+" ");
			} 
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}
}