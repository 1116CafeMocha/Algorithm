// 백준 11724번. 연결 요소의 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		
		input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		List<List<Integer>> graph = new ArrayList<>();
		boolean[] visited = new boolean[N+1];
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			input = br.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		int count = 0;
		Queue<Integer> que = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			if(visited[i]) continue;
			
			count++;
			que.offer(i);
			visited[i] = true;
			while(!que.isEmpty()) {
				int now = que.poll();
				
				int size = graph.get(now).size();
				for(int k=0; k<size; k++) {
					int next = graph.get(now).get(k);
					
					if(visited[next]) continue;
					visited[next] = true;
					que.add(next);
				}
			}
		}
		
		System.out.println(count);
	}

}
