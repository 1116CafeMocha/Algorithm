import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static int N, M;
	static List<Node>[] graph;
	static boolean[] visited;
	
	static class Node {
		int to;
		int weight;
		
		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			int C = Integer.parseInt(input[2]);
			
			graph[A].add(new Node(B, C));
			graph[B].add(new Node(A, C));
		}
		
		for(int i=0; i<M; i++) {
			input = br.readLine().split(" ");
			
			int start = Integer.parseInt(input[0]);
			int target = Integer.parseInt(input[1]);
			
			Arrays.fill(visited, false);
			
			int dist = dfs(start, target, 0);
			bw.write(Integer.toString(dist));
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
	
	static int dfs(int now, int target, int dist) {
		if(now == target) return dist;
		
		visited[now] = true;
		
		for(Node next : graph[now]) {
			if(!visited[next.to]) {
				int answer = dfs(next.to, target, dist + next.weight);
				
				if(answer != -1) {
					return answer;
				}
			}
		}
		
		return -1;
	}

}
