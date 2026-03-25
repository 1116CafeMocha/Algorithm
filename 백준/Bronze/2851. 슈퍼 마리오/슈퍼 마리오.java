import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Long[] arr = new Long[10];
		arr[0] = Long.parseLong(br.readLine());
		
		for(int i=1; i<10; i++) {
			arr[i] = arr[i-1] + Long.parseLong(br.readLine());
		}
		
		long answer = 0;
		for(long now : arr) if(Math.abs(100 - now) <= Math.abs(100 - answer)) answer = now;
		bw.write(Long.toString(answer));
		
		bw.flush();
		bw.close();
	}

}