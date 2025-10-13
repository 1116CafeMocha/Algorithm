import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		if (N == 1) {
			System.out.println(0);
			return;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		while(N-- > 0) {
			int val = Integer.parseInt(br.readLine());
			pq.offer(val);
		}
		
		long answer = 0L;
		while(pq.size() > 1) {
			int A = pq.poll();
			int B = pq.poll();
			int sum = A + B;
			answer += sum;
			pq.offer(sum);
		}
		
		bw.write(Long.toString(answer));
		
		bw.flush();
		bw.close();
	}
}
