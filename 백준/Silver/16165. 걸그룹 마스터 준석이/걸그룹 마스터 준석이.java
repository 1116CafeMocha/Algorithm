import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Set<String>> groupToMem = new HashMap<>();
		Map<String, String> memToGroup = new HashMap<>();
		
		while(N-- > 0) {
			String group = br.readLine();
			int num = Integer.parseInt(br.readLine());
			for(int i=0; i<num; i++) {
				String mem = br.readLine();
				memToGroup.put(mem, group);
				if(groupToMem.containsKey(group)) {
					groupToMem.get(group).add(mem);
				}else {
					groupToMem.put(group, new TreeSet<>());
					groupToMem.get(group).add(mem);
				}
			}
		}
		
		while(M-- > 0) {
			String qst = br.readLine();
			int Q = Integer.parseInt(br.readLine());
			if(Q == 0) {
				for(String now : groupToMem.get(qst)) {
					bw.write(now);
					bw.newLine();
				}				
			}else {
				bw.write(memToGroup.get(qst));
				bw.newLine();
			}
		}
		
		bw.flush();
		bw.close();
	}

}
