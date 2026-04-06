import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 양수, 0, 음수
// 1보다 큰 양수 : 큰거끼리 곱함
// 1 : 곱X
// 0 : 음수 없애기
// 음수 : 절댓값 큰거끼리 곱함

public class Main {
	static boolean[] broken;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> pos = new ArrayList<>();
		List<Integer> neg = new ArrayList<>();
		int one = 0;
		int zero = 0;
		
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(br.readLine());
			
			if(now > 1) pos.add(now);
			else if(now == 1) one++;
			else if (now == 0) zero++;
			else neg.add(now);
		}
		
		Collections.sort(pos, Collections.reverseOrder());
		Collections.sort(neg);
		
		int sum = one;
		
		for(int i=0; i<pos.size(); i+=2) {
			// 둘씩 곱해서 더해줌
			if(i+1 < pos.size()) sum += pos.get(i) * pos.get(i+1);
			else sum += pos.get(i);
		}
		
		for(int i=0; i<neg.size(); i+=2) {
			if(i+1 < neg.size()) sum += neg.get(i) * neg.get(i+1);
			else if(zero == 0) sum += neg.get(i); // 0이 있으면 남은 음수 하나를 0과 곱해 없앨 수 있음
		}
		
		bw.write(Integer.toString(sum));
		
		bw.flush();
		bw.close();
	}

}