import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 부분 배열이 아니라 부분 수열임! (연속된 인덱스가 아니어도 됨)

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int[] lis = new int[N];
		int[] lds = new int[N];
		
		for(int i=0; i<N; i++) {
			lis[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i]) lis[i] = Math.max(lis[i], lis[j]+1);
			}
		}
		
		for(int i=N-1; i>=0; i--) {
			lds[i] = 1;
			for(int j=N-1; j>i; j--) {
				if(arr[j] < arr[i]) lds[i] = Math.max(lds[i], lds[j]+1);
			}
				
		}
		
		int ans = 0;
		for(int i=0; i<N; i++) ans = Math.max(ans, lis[i] + lds[i] - 1);
		
		bw.write(Integer.toString(ans));
		
		bw.flush();
		bw.close();
	}

}