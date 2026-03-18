import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	static class Node implements Comparable<Node> {
		int val;
		int idx;
		
		Node(int val, int idx){
			this.val = val;
			this.idx = idx;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.val, o.val);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Node[] arr = new Node[N];
		
		for(int i=0; i<N; i++) {
			int val = Integer.parseInt(br.readLine());
			arr[i] = new Node(val, i);
		}
		
		Arrays.sort(arr);
		
		int MAX = 0;
		for(int i=0; i<N; i++) {
			MAX = Math.max(MAX, arr[i].idx - i);
		}
		
		bw.write(Integer.toString(MAX + 1));
		
		bw.flush();
		bw.close();
	}

}