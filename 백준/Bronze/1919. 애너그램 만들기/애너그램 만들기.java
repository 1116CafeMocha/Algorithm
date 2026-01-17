import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Map<Character, Integer> mapA = new HashMap<>();
		Map<Character, Integer> mapB = new HashMap<>();
		
		String A = br.readLine();
		String B = br.readLine();
		
		for(int i=0; i<A.length(); i++) {
			char now = A.charAt(i);
			mapA.put(now, mapA.getOrDefault(now, 0)+1);
		}
		
		for(int i=0; i<B.length(); i++) {
			char now = B.charAt(i);
			mapB.put(now, mapB.getOrDefault(now, 0)+1);
		}
		
		int count = 0;
		
		for(char now :  mapA.keySet()) {
			if(!mapB.containsKey(now)) {
				count += mapA.get(now);
				continue;
			}
			
			if(mapA.get(now) != mapB.get(now)) {
				count += Math.abs(mapA.get(now) - mapB.get(now));
			}
		}
		
		for(char now :  mapB.keySet()) {
			if(!mapA.containsKey(now)) {
				count += mapB.get(now);
				continue;
			}
		}
		
		bw.write(Integer.toString(count));
		
		bw.flush();
		bw.close();
	}
}
