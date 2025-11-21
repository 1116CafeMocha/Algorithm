import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N==1) {
			bw.write("0");
			bw.flush();
			bw.close();
			return;
		}
		
		int voted = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=2; i<=N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int count = 0;
		
		while(!pq.isEmpty() && voted <= pq.peek()){
			int top = pq.poll();
			top--;
			voted++;
			count++;
			
			pq.offer(top);
		}
		
		bw.write(Integer.toString(count));
		
		bw.flush();
		bw.close();
	}
	
}
