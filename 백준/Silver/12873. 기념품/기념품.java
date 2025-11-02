import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		
		long T = 1;
		int idx = 0;
		
		while(list.size() > 1) {
			long temp = (T*T*T-1) % list.size();
			idx = (int)(temp + idx) % list.size();
			list.remove(idx);
			
			T++;
		}
		
		bw.write(Integer.toString(list.get(0)));

		bw.flush();
		bw.close();
	}

}
