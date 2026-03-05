import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS
// 천의 자리는 0이 되면 안 됨
// 처음 수 A면 continue

public class Main {
	static class Node {
		int num;
		int count;
		
		Node(int num, int count){
			this.num = num;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] arr = new boolean[10000];
		arr[0] = true;
		arr[1] = true;
		
		for(int i=4; i<10000; i+=2) arr[i] = true;
		
		for(int i=3; i*i<10000; i+=2) {
			if(arr[i]) continue;
			for(int j=i*i; j<10000; j+=i*2) arr[j] = true;
		}
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int answer = bfs(A, B, arr);
			
			if(answer == -1) bw.write("Impossible\n");
			else bw.write(answer + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static int bfs (int start, int target, boolean[] arr) {
		boolean[] visited = new boolean[10000];
		Queue<Node> que = new ArrayDeque<>();
		
		que.offer(new Node(start, 0));
		visited[start] = true;
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			
			if(now.num == target) return now.count;
			
			char[] cur = String.valueOf(now.num).toCharArray();
			
			for(int i=0; i<4; i++) {
				char original = cur[i];
				
				for(char c = '0'; c<='9'; c++) {
					if(c == original) continue;
					
					if(i==0 && c=='0') continue;
					
					cur[i] = c;
					int next = Integer.parseInt(new String(cur));
					
					if(arr[next]) continue;
					
					if(visited[next]) continue;
					
					visited[next] = true;
					que.offer(new Node(next, now.count + 1));
				}
				
				cur[i] = original;
			}
		}
		return -1;
	}

}