import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static class Student {
		String name;
		int vote;
		
		Student(String name, int vote){
			this.name = name;
			this.vote = vote;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Student[] arr = new Student[N];
		Map<String, Integer> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			String name = st.nextToken();
			arr[i] = new Student(name, 0);
			map.put(name, i);
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				arr[map.get(st.nextElement())].vote++;
			}
		}
		
		Arrays.sort(arr, (a, b) -> {
			if(a.vote != b.vote) {
				return b.vote - a.vote;
			}
			
			return a.name.compareTo(b.name);
		});
		
		for(int i=0; i<N; i++) {
			bw.write(arr[i].name + " " + arr[i].vote);
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}

}
