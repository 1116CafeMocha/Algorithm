import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine(), "-");
			int size = st.countTokens();
			for(int j=0; j<size; j++) {
				if(st.nextToken().contains("FBI")) {
					list.add(i+1);
					break;
				}
			}
		}
		
		if(list.size() == 0) bw.write("HE GOT AWAY!");
		else for(int now : list) bw.write(now + " ");
		
		bw.flush();
		bw.close();
	}

}