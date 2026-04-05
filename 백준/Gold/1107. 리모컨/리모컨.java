import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 시작 지점은 100
// 근데 목표 지점에서 가장 가까운 이동 가능한 채널부터 시작하면 좋지 않나...?
// 일단 브루트포스

public class Main {
	static boolean[] broken;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		broken = new boolean[10];
		
		// M == 0 확인해야함
		
		if(M != 0) {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) broken[Integer.parseInt(st.nextToken())] = true;
		}
		
		// 초기값 : 숫자 버튼 안쓰고 이동할 경우
		int answer = Math.abs(N - 100);
		
		for(int i=0; i<= 999999; i++) {
			int len = check(i);
			
			if(len > 0) {
				answer = Math.min(answer, len + Math.abs(N - i));
			}
		}
		
		bw.write(Integer.toString(answer));

		bw.flush();
		bw.close();
	}
	
	// 숫자 c를 버튼으로 이동 가능한지 확인
	// 안되면 0 리턴
	static int check(int c) {
		if(c == 0) {
			if(broken[0]) return 0;
			else return 1;
		}
		
		int len = 0;
		
		while(c > 0) {
			int digit = c % 10;
			if(broken[digit]) return 0;
			
			len++;
			c /= 10;
		}
		
		return len;
	}
}