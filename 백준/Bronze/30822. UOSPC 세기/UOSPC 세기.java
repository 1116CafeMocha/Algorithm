import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		char[] arr = str.toCharArray();

		int numU = 0;
		int numO = 0;
		int numS = 0;
		int numP = 0;
		int numC = 0;

		for (char now : arr) {
			if (now == 'u')
				numU++;
			else if (now == 'o')
				numO++;
			else if (now == 's')
				numS++;
			else if (now == 'p')
				numP++;
			else if (now == 'c')
				numC++;
		}

		bw.write(Integer.toString(Math.min(numU, Math.min(numO, Math.min(numS, Math.min(numP, numC))))));

		bw.flush();
		bw.close();
	}
}
