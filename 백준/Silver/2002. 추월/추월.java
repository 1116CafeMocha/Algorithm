import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// 권장 풀이

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> idx = new HashMap<>(N*2);
		String[] in = new String[N];
		boolean[] out = new boolean[N];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine().strip();
			in[i] = input;
			idx.put(input, i);
		}
		
		int peekIdx = 0;
		int count = 0;
		
		for(int i=0; i<N; i++) {
			String input = br.readLine().strip();
			int j = idx.get(input);
			out[j] = true;
			
			if(j != peekIdx) {
				count++;
			} else {
				while(peekIdx < N && out[peekIdx]) peekIdx++;
			}
		}
		
		bw.write(Integer.toString(count));
		
		bw.flush();
		bw.close();
	}

}
