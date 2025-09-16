import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] arr = br.readLine().toCharArray();
		int count = 0;
		for (char now : arr) {
			if (now == 'a' || now == 'e' || now == 'i' || now == 'o' || now == 'u')
				count++;
		}
		
		bw.write(Integer.toString(count));

		bw.flush();
		bw.close();
	}

}
