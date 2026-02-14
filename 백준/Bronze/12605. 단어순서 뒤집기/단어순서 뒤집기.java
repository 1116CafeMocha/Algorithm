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
		for(int i=1; i<=N; i++) {
			String[] input = br.readLine().split(" ");
			int len = input.length;
			bw.write("Case #"+i+": ");
			for(int j=len-1; j>=0; j--)
				bw.write(input[j] + " ");
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}

}