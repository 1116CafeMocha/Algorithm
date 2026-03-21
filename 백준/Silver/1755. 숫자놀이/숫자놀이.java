import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Map<Integer, String> map1 = new HashMap<>();
		map1.put(0, "zero");
		map1.put(1, "one");
		map1.put(2, "two");
		map1.put(3, "three");
		map1.put(4, "four");
		map1.put(5, "five");
		map1.put(6, "six");
		map1.put(7, "seven");
		map1.put(8, "eight");
		map1.put(9, "nine");
		
		Map<String, Integer> map2 = new HashMap<>();
		map2.put("zero", 0);
		map2.put("one", 1);
		map2.put("two", 2);
		map2.put("three", 3);
		map2.put("four", 4);
		map2.put("five", 5);
		map2.put("six", 6);
		map2.put("seven", 7);
		map2.put("eight", 8);
		map2.put("nine", 9);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		TreeSet<String> set = new TreeSet<>();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=M; i<=N; i++) {
			String num = Integer.toString(i);
			String str = "";
			
			for(int j=0; j<num.length(); j++) {
				int now = num.charAt(j) - '0';
				str += map1.get(now);
				str += " ";
			}
			
			set.add(str);
		}
		
		int idx = 1;
		for(String s : set) {
			st = new StringTokenizer(s);
			int size = st.countTokens();
			for(int i=0; i<size; i++) bw.write(Integer.toString(map2.get(st.nextToken())));
			if(idx % 10 == 0) bw.newLine();
			else bw.write(" ");
			idx++;
		}
		
		bw.flush();
		bw.close();
	}

}