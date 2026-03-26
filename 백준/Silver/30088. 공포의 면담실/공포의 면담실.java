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
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		for(int i=0; i<N; i++) {
			Long sum = 0L;
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				sum += Integer.parseInt(st.nextToken());
			}
			arr[i] = sum;
		}
		
		Arrays.sort(arr);
		Long sum = arr[0];
		for(int i=1; i<N; i++) {
			arr[i] = arr[i-1] + arr[i];
			sum += arr[i];
		}
		
		bw.write(Long.toString(sum));
		
		bw.flush();
		bw.close();
	}

}