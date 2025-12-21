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
		Set<String> set = new HashSet<>();
		
		char pre = '!';
		char next = '!';
		
		for(int i=0; i<N; i++) {
			String now = br.readLine();
			if(now.charAt(0) == '?'){
				if(i != 0) {
					pre = arr[i-1].charAt(arr[i-1].length()-1);
				}
			}
			else {
				set.add(now);
				
				if(i != 0) {
					if(arr[i-1].charAt(0) == '?') {
						next = now.charAt(0);
					}
				}
			}
			arr[i] = now;
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			String now = br.readLine();
			if(set.contains(now)) continue;
			if(pre != '!' && now.charAt(0) != pre) continue;
			if(next != '!' && now.charAt(now.length()-1) != next) continue;
			bw.write(now);
			break;
		}
		
		bw.flush();
		bw.close();
	}

}
