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
		String[] input = br.readLine().split(" ");
		int v = Integer.parseInt(br.readLine());
		
		int count = 0;
		
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(input[i]);
			if(now == v) count++;
		}
		
		bw.write(count+"");
		
		bw.flush();
		bw.close();
	}
}
