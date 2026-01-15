import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[10];
		for(int i=0; i<2; i++) {
			for(int j=0; j<10; j++) {
				arr[j] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(arr);
			bw.write(arr[9]+arr[8]+arr[7] + " ");
		}
		
		bw.flush();
		bw.close();
	}
}
