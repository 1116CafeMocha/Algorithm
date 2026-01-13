import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		Stack<Character> stack = new Stack<>();
		while(N-- > 0) {
			String input = br.readLine();
			stack.add(input.charAt(0));
			for(int i=1; i<input.length(); i++) {
				char now = input.charAt(i);
				if(!stack.isEmpty() && stack.peek() == now) stack.pop();
				else stack.add(now);
			}
			if(stack.isEmpty()) count++;
			else stack.clear();
		}
		
		bw.write(Integer.toString(count));
		
		bw.flush();
		bw.close();
	}
}
