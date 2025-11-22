import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			
			if(A==0) {
				if(pq.isEmpty()) {
					bw.write("-1\n");
				}
				else {
					bw.write(Integer.toString(pq.poll()));
					bw.newLine();
				}
			}else {
				for(int j=0; j<A; j++) {
					pq.add(Integer.parseInt(st.nextToken()));
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
	
}
