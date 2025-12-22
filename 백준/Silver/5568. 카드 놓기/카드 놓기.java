import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static int N, K;
	static String[] arr;
	static boolean[] visited;
	static Set<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		arr = new String[N];
		visited = new boolean[N];
		set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		dfs(0, "");
		
		bw.write(Integer.toString(set.size()));
		
		bw.flush();
		bw.close();
	}
	
	static void dfs(int idx, String str) {
		if(idx == K) {
			set.add(str);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			dfs(idx + 1, str + arr[i]);
			visited[i] = false;
		}
	}

}
