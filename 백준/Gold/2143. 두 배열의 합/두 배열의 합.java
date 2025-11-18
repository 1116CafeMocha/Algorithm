import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long T = Long.parseLong(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int[] B = new int[M];
		for(int i=0; i<M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Long, Long> mapA = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			long sum = 0;
			
			for(int j=i; j<N; j++) {
				sum += A[j];
				mapA.put(sum, mapA.getOrDefault(sum, 0L) + 1);
			}
		}
		
		long count = 0;
		
		for(int i=0; i<M; i++) {
			long sum = 0;
			
			for(int j=i; j<M; j++) {
				sum += B[j];
				
				// A에서 찾아야 하는 목표값
				long target = T - sum;
				
				// mapA에서 목표값 카운팅한 값 더하기
				if(mapA.containsKey(target)) {
					count += mapA.get(target);
				}
			}
		}
		
		bw.write(Long.toString(count));
		
		bw.flush();
		bw.close();
	}

}
