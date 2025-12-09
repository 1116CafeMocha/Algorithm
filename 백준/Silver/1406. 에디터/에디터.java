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
		
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());
		
		Deque<Character> left = new ArrayDeque<>();
		Deque<Character> right = new ArrayDeque<>();
		
		for(char now : str.toCharArray()) {
			left.offer(now);
		}
		
		while(M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char order = st.nextToken().charAt(0);
			
			if(order == 'L') {
				if(left.isEmpty()) continue;
				right.offerFirst(left.pollLast());
			}

			if(order == 'D') {
				if(right.isEmpty()) continue;
				left.offerLast(right.pollFirst());
			}

			if(order == 'B') {
				if(left.isEmpty()) continue;
				left.pollLast();
			}

			if(order == 'P') {
				left.offerLast(st.nextToken().charAt(0));
			}
		}
		
		for(char now : left) bw.write(now);
		for(char now : right) bw.write(now);
		
		bw.flush();
		bw.close();
	}

}
