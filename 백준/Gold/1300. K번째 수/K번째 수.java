import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 그냥 값 다 입력하고 정렬하면 터짐.
// 각 행에서 K보다 작은 값이 몇 개인지 카운팅. (N보다 크면 N으로 제한)

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long K = Long.parseLong(br.readLine());
		
		long low = 1;
		long high = K;
		long answer = 0;
		
		while(low <= high) {
			long mid = (low + high) / 2;
			long count = 0;
			
			for(int i=1; i<=N; i++) {
				count += Math.min(N, (int)(mid / i));
				if(count >= K) break;
			}
			
			if(count >= K) {
				answer = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		bw.write(Long.toString(answer));
		
		bw.flush();
		bw.close();
	}

}