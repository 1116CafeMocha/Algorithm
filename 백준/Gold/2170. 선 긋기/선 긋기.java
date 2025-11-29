import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		int[][] lines = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			lines[i][0] = X;
			lines[i][1] = Y;
		}
		
		Arrays.sort(lines, (a, b) -> {
			if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
			return Integer.compare(a[0], b[0]);
		});
		
		long answer = 0;
		
		int nowX = lines[0][0];
		int nowY = lines[0][1];
		
		for(int i=1; i<N; i++) {
			int X = lines[i][0];
			int Y = lines[i][1];
			
			if(X > nowY) {
				answer += (long) nowY - nowX;
				nowX = X;
				nowY = Y;
			}else {
				if(Y > nowY) {
					nowY = Y;
				}
			}
		}
		
		answer += (long) nowY - nowX;
		
		bw.write(Long.toString(answer));

		bw.flush();
		bw.close();
	}

}
