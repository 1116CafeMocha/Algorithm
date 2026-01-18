import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static TreeMap<Integer, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		map = new TreeMap<>();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int K = Integer.parseInt(br.readLine());
			
			while(K-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char order = st.nextToken().charAt(0);
				int N = Integer.parseInt(st.nextToken());
				if(order == 'I') insert(N);
				else if(order == 'D' && N == 1) removeMax();
				else removeMin();
			}
			if(map.isEmpty()) bw.write("EMPTY\n");
			else bw.write(map.lastKey() + " " + map.firstKey() + "\n");
			
			map.clear();
		}
		
		bw.flush();
		bw.close();
	}
	
	static void insert(int x) {
		map.put(x, map.getOrDefault(x, 0) + 1);
		return;
	}
	
	static void removeMax() {
		if(map.isEmpty()) return;
		
		int Max = map.lastKey();
		
		map.put(Max, map.get(Max)-1);
		
		if(map.get(Max)==0) map.remove(Max);
		return;
	}
	
	static void removeMin() {
		if(map.isEmpty()) return;
		
		int Min = map.firstKey();
		
		map.put(Min, map.get(Min)-1);
		
		if(map.get(Min)==0) map.remove(Min);
		return;
	}
}
