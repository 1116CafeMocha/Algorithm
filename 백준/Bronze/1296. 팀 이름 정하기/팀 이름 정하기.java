import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int L, O, V, E;
	
	static class Name{
		String name;
		int val;
		
		Name(String name, int val){
			this.name = name;
			this.val = val;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		L = 0;
		O = 0;
		V = 0;
		E = 0;
		
		String input = br.readLine();
		for(int i=0; i<input.length(); i++) {
			char now = input.charAt(i);
			if(now == 'L') L++;
			else if(now == 'O') O++;
			else if(now == 'V') V++;
			else if(now == 'E') E++;
		}
		
		int N = Integer.parseInt(br.readLine());
		Name[] names = new Name[N];
		
		for(int i=0; i<N; i++) {
			String nowName = br.readLine();
			int nowVal = cal(nowName);
			
			names[i] = new Name(nowName, nowVal);
		}
		
		Arrays.sort(names,(a, b) -> {
			if(a.val != b.val) return b.val - a.val;
			return a.name.compareTo(b.name);
		});
		
		bw.write(names[0].name);
		
		bw.flush();
		bw.close();
	}
	
	static int cal(String str) {
		int nowL = 0;
		int nowO = 0;
		int nowV = 0;
		int nowE = 0;
		
		for(int i=0; i<str.length(); i++) {
			char now = str.charAt(i);
			if(now == 'L') nowL++;
			else if(now == 'O') nowO++;
			else if(now == 'V') nowV++;
			else if(now == 'E') nowE++;
		}
		nowL += L;
		nowO += O;
		nowV += V;
		nowE += E;
		
		int result = ((nowL+nowO)*(nowL+nowV)*(nowL+nowE)*(nowO+nowV)*(nowO+nowE)*(nowV+nowE)) % 100;
		return result;
	}
}