import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;
		int X = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			input = br.readLine().split(" ");
			sum += Integer.parseInt(input[0])*Integer.parseInt(input[1]);
		}
		
		if(X == sum) bw.write("Yes");
		else bw.write("No");

		bw.flush();
		bw.close();
	}

}
