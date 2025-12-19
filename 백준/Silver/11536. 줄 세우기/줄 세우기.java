import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		String[] sorted = arr.clone();
		Arrays.sort(sorted);
		
		boolean isInc = true;
		boolean isDec = true;
		
		for(int i=0; i<N; i++) {
			if(!arr[i].equals(sorted[i])) {
				isInc = false;
				break;
			}
		}
		
		if(isInc) {
			System.out.println("INCREASING");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!arr[i].equals(sorted[N-1-i])) {
				isDec = false;
				break;
			}
		}
		
		if(isDec) {
			System.out.println("DECREASING");
			return;
		}
		
		bw.write("NEITHER");
		
 		bw.flush();
		bw.close();
	}

}
