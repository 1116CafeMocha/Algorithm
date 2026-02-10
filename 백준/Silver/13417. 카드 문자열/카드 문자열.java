import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Deque<Character> deq = new ArrayDeque<>();
			while(N-- > 0) {
				char now = st.nextToken().charAt(0);
				if(deq.isEmpty() || deq.peekFirst() >= now) deq.addFirst(now);
				else deq.addLast(now);
			}
			
			for(char now : deq) bw.write(now);
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}
}