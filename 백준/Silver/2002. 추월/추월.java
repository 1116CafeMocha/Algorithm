import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Queue<String> que = new ArrayDeque<>();
		Map<String, Boolean> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String now = br.readLine().strip();
			que.offer(now);
			map.put(now, false);
		}
		
		String now = que.poll();
		map.put(now, true);
		int count = 0;
		
		for(int i=0; i<N; i++) {
			String input = br.readLine().strip();
			
			if(input.equals(now)) {
				map.put(now, true);
				while(!que.isEmpty() && map.get(now)) {
					now = que.poll();
				}
				continue;
			}
			
			if(map.get(input)) continue;
			
			map.put(input, true);
			count++;
		}
		
		bw.write(Integer.toString(count));
		
		bw.flush();
		bw.close();
	}

}
