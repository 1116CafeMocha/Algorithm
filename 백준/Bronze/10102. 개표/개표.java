import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int V = Integer.parseInt(br.readLine());
		int A = 0;
		int B = 0;
		
		String str = br.readLine();
		
		for(int i=0; i<V; i++) {
			char now = str.charAt(i);
			if(now == 'A') A++;
			else B++;
		}
		
		if(A > B) bw.write("A");
		else if (A < B) bw.write("B");
		else bw.write("Tie");
		
		bw.flush();
		bw.close();
	}

}
