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
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		int len = arr[0].length();
		
		for(int i=1; i<=len; i++) {
			Set<String> set = new HashSet<>();
			for(String now : arr) {
				set.add(now.substring(len-i));
			}
			if(set.size() == N) {
				bw.write(Integer.toString(i));
				break;
			}
		}
		
		bw.flush();
		bw.close();
	}

}
