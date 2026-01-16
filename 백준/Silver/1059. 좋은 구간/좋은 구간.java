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
		
		int L = Integer.parseInt(br.readLine());
		int[] arr = new int[L];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<L; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int N = Integer.parseInt(br.readLine());
		
		for(int now : arr) if(now == N) {
			System.out.println(0);
			return;
		}
		
		int left = 0;
		int right = 1001;
		
		for(int now : arr) {
			if(now < N) left = now;
			else if (now > N) {
				right = now;
				break;
			}
		}
		
		bw.write(Integer.toString((N-left) * (right - N) - 1));
		
		bw.flush();
		bw.close();
	}
}
