import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int NA = Integer.parseInt(st.nextToken());
		int NB = Integer.parseInt(st.nextToken());
		
		Set<Integer> A = new TreeSet<>();
		Set<Integer> B = new TreeSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<NA; i++) A.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<NB; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(A.contains(num)) A.remove(num);
		}
		bw.write(Integer.toString(A.size()));
		
		if(A.size() != 0) {
			bw.newLine();
			for(int now : A) bw.write(now + " ");			
		}
		
		bw.flush();
		bw.close();
	}
}
