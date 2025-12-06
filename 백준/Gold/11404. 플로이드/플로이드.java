import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1_000_000_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] dist = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) dist[i][j] = 0;
				else dist[i][j] = INF;
			}
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			if(C < dist[A][B]) {
				dist[A][B] = C;
			}
		}
		
		// 중간 도시
		for(int i=1; i<=N; i++) {
			// 출발 도시
			for(int j=1; j<=N; j++) {
				// 도착 도시
				for(int k=1; k<=N; k++) {
					if(dist[j][i] == INF || dist[i][k] == INF) continue;
					int newCost = dist[j][i] + dist[i][k];
					if(dist[j][k] > newCost) {
						dist[j][k] = newCost;
					}
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(dist[i][j] == INF) bw.write("0 ");
				else bw.write(dist[i][j] + " ");
			}
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}

}
