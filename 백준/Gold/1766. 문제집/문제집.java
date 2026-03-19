import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// A를 먼저 풀고 B를 풀어야 한다.
// 난이도 순서(작은 숫자부터) 대로 풀어야 한다.
// => 진입차수가 0인 문제들을 우선순위큐에 넣고 작은 숫자 번호부터 꺼내서 풀기
// => 풀었으면 그 문제와 연관된 다음 문제들의 진입차수 -1
// => 진입차수 0된거 우선순위큐에 넣고 진행 반복

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] graph = new ArrayList[N+1];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<=N; i++) graph[i] = new ArrayList<>();
		
		// 진입차수 배열
		int[] indegree = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph[A].add(B);
			indegree[B]++;
		}
		
		for(int i=1; i<=N; i++) if(indegree[i] == 0) pq.offer(i);
		
		while(!pq.isEmpty()) {
			int now = pq.poll();
			bw.write(now + " ");
			
			for(int next : graph[now]) {
				indegree[next]--;
				
				if(indegree[next] == 0) pq.offer(next);
			}
		}
		
		bw.flush();
		bw.close();
	}

}