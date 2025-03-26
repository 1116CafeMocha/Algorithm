import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 백준 10809번. 알파벳 찾기

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] S = br.readLine().split("");
		int[] count = new int[26];
		Arrays.fill(count, -1);
		
		for(int i=0; i<S.length; i++) {
			int now = (int) S[i].charAt(0) - 97;
			if(count[now] == -1) count[now] = i;
		}
		
		for(int i=0; i<26; i++) bw.write(count[i]+" ");
		
		bw.flush();
		bw.close();
	}

}
