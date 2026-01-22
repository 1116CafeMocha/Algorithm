import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		int answer = 0;
		
		for (int i = 0; i < input.length(); i++) {
            int d = input.charAt(i) - '0';
            answer = (answer * 10 + d) % 20000303;
        }
		
		bw.write(Integer.toString(answer));
		
		bw.flush();
		bw.close();
	}
}
