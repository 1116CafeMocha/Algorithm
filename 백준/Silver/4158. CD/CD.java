import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		Set<Integer> set = new HashSet<>();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int count = 0;
			
			if(N == 0 && M == 0) break;
			
			set.clear();
			
			for(int i=0; i<N; i++) set.add(Integer.parseInt(br.readLine()));
			
			for(int i=0; i<M; i++) {
				int now = Integer.parseInt(br.readLine());
				if(set.contains(now)) count++;
			}
			
			bw.write(count + "\n");
		}
		
        bw.flush();
        bw.close();
	}

}