import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] map = new boolean[N][N];
		
		for(int r=0; r<N; r++) {
			String input = br.readLine();
			for(int c=0; c<N; c++) {
				char now = input.charAt(c);
				if(now == '.') map[r][c] = true;
			}
		}
		
		int answerR = 0;
		int answerC = 0;
		
		for(int r=0; r<N; r++) {
			int count = 0;
			
			for(int c=0; c<N; c++) {
				boolean now = map[r][c];
				
				if(!now) {
					if(count >= 2) {
						answerR++;
					}
					count = 0;
				} else {
					count++;
				}
				
				if(c == N-1) {
					if(count >= 2) answerR++;
				}
			}
		}
		
		for(int c=0; c<N; c++) {
			int count = 0;
			
			for(int r=0; r<N; r++) {
				boolean now = map[r][c];
				
				if(!now) {
					if(count >= 2) {
						answerC++;
					}
					count = 0;
				} else {
					count++;
				}
				
				if(r == N-1) {
					if(count >= 2) answerC++;
				}
			}
		}
		
		bw.write(answerR + " " + answerC);
		
		bw.flush();
		bw.close();
	}

}
