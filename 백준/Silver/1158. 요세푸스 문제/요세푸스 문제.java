import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Integer> que = new LinkedList<>();
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		for(int i=1; i<=N; i++) {
			que.add(i);
		}
		
		System.out.print("<");
		
		while(que.size()!=0) {
			for(int i=0; i<K-1; i++) {
				int temp = que.poll();
				que.add(temp);
			}
			System.out.print(que.poll());
			if(que.size()!=0) System.out.print(", ");
		}
		
		System.out.print(">");
	}

}