import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;
	
	public class Main {
		static int N;
		static List<Integer>[] graph;
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			N = Integer.parseInt(br.readLine());
			graph = new ArrayList[N+1];
			
			for(int i=1; i<=N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0; i<N-1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				graph[A].add(B);
				graph[B].add(A);
			}
			
			int[] seq = new int[N];
			int[] pos = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				seq[i] = Integer.parseInt(st.nextToken());
				pos[seq[i]] = i;
			}
			
			if(seq[0] != 1) {
				System.out.println("0");
				return;
			}
			
			// 입력에서 제시된 수열에서 먼저 나오는 순서대로 정렬
			for (int i = 1; i <= N; i++) {
	            graph[i].sort(Comparator.comparingInt(o -> pos[o]));
	        }
			
			// dfs를 재귀로 하면 스택오버플로우 위험이 있음. 반복 dfs 사용
			boolean[] visited = new boolean[N + 1];
	        int[] iterIdx = new int[N + 1];
	        int[] visitOrder = new int[N];
	        int visitCnt = 0;
	        
	        Deque<Integer> stack = new ArrayDeque<>();
	        stack.push(1);

	        while (!stack.isEmpty()) {
	            int v = stack.peek();

	            if (!visited[v]) {
	                visited[v] = true;
	                visitOrder[visitCnt++] = v;
	            }

	            boolean pushed = false;
	            while (iterIdx[v] < graph[v].size()) {
	                int nxt = graph[v].get(iterIdx[v]++);
	                if (!visited[nxt]) {
	                    stack.push(nxt);
	                    pushed = true;
	                    break;
	                }
	            }
	            if (!pushed) stack.pop();
	        }

	        for (int i = 0; i < N; i++) {
	            if (visitOrder[i] != seq[i]) {
	                System.out.println(0);
	                return;
	            }
	        }
	        bw.write("1");
			
			bw.flush();
			bw.close();
		}
		
	}
