import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// replace로 제거하면 순서대로 제거되면서 원래는 No여야 하는 경우도 YES 출력되는 문제 발생
// 반례 : kpia

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		boolean flag = true;
		
		int i=0;
		while (i < str.length()) {
            if (i + 2 <= str.length() && str.substring(i, i + 2).equals("pi")) {
                i += 2;
            } else if (i + 2 <= str.length() && str.substring(i, i + 2).equals("ka")) {
                i += 2;
            } else if (i + 3 <= str.length() && str.substring(i, i + 3).equals("chu")) {
                i += 3;
            } else {
            	flag = false;
                break;
            }
        }
		
		if(flag) bw.write("YES");
		else bw.write("NO");
		
		bw.flush();
		bw.close();
	}
	
}