import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

public class Main {
	static TreeMap<Integer, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] arr = br.readLine().toCharArray();
		
		for(int i=0; i<arr.length; i++) {
			char now = arr[i];
			if(!Character.isAlphabetic(now)) continue;
			arr[i] = ROT13(now);
		}
		
		for(char now : arr) bw.write(now);
		
		bw.flush();
		bw.close();
	}
	
	static char ROT13 (char c) {
		
		if(Character.isUpperCase(c)) {
			int val = ((int)c + 13);
			if(val > 90) return (char)(val%91 + 65);
			return (char)val;
		}
		int val = ((int)c + 13);
		if(val > 122) return (char)(val%123 + 97);
		return (char)val;
	}
}
