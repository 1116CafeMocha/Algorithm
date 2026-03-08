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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		if(K >= N) {
			System.out.println("0\n");
			return;
		}
		
		int[] points = new int[N-1];
		for(int i=0; i<N-1; i++) {
			points[i] = arr[i+1] - arr[i];
		}
		
		Arrays.sort(points);
		
		int answer = 0;
		for(int i=0; i<N-K; i++) {
			answer += points[i];
		}
		
		bw.write(Integer.toString(answer));
		
		bw.flush();
		bw.close();
	}
	
}