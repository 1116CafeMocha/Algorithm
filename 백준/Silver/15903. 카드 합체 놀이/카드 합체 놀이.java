	import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
	
	public class Main {
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			Queue<Long> que = new PriorityQueue<>();
			for(int i=0; i<N; i++) {
				que.add(Long.parseLong(st.nextToken()));
			}
			
			while(M-- > 0) {
				long A = que.poll();
				long B = que.poll();
				que.add(A+B);
				que.add(A+B);
			}
			
			long sum = 0L;
			for(long now : que)
				sum += now;
			
			bw.write(Long.toString(sum));
			
			bw.flush();
			bw.close();
		}
		
	}
