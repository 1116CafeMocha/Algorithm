import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			
			List<Integer>[] arr = new ArrayList[26];
			for(int i=0; i<26; i++) arr[i] = new ArrayList<>();
			
			for(int i=0; i<W.length(); i++) {
				char now = W.charAt(i);
				arr[now - 'a'].add(i);
			}
			
			int MIN = Integer.MAX_VALUE;
			int MAX = Integer.MIN_VALUE;
			
			for(int i=0; i<26; i++) {
				List<Integer> list = arr[i];
				
				if(list.size() < K) continue;
				
				for(int j=0; j<list.size()-K+1; j++) {
					int start = list.get(j);
					int end = list.get(j+K-1);
					int len = end - start + 1;
					
					MIN = Math.min(MIN, len);
					MAX = Math.max(MAX, len);
				}
			}
			if(MIN == Integer.MAX_VALUE) bw.write("-1\n");
			else bw.write(MIN + " " + MAX + "\n");
		}
		
		bw.flush();
		bw.close();
	}

}