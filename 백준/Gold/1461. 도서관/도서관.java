import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer> pos = new ArrayList<>();
		List<Integer> neg = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(now < 0) neg.add(Math.abs(now));
			else pos.add(now);
		}
		
		Collections.sort(pos, Collections.reverseOrder());
		Collections.sort(neg, Collections.reverseOrder());
		
		int MAX = 0;
		if(!pos.isEmpty()) MAX = Math.max(MAX, pos.get(0));
		if(!neg.isEmpty()) MAX = Math.max(MAX, neg.get(0));
		
		int answer = 0;
		
		for(int i=0; i<pos.size(); i+=M) answer += pos.get(i)*2;
		for(int i=0; i<neg.size(); i+=M) answer += neg.get(i)*2;
		
		answer -= MAX;
		
		bw.write(Integer.toString(answer));
		
		bw.flush();
		bw.close();
	}

}