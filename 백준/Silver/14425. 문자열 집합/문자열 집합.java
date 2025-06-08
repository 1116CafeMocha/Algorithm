import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int count = 0;
		
		Set<String> set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		
		for(int i=0; i<M; i++) {
			if(set.contains(br.readLine())) count++;
		}
		
		bw.write(Integer.toString(count));
		
		bw.flush();
		bw.close();
	}
}
