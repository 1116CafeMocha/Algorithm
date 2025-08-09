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

		String answer;

		if (N >= 620 && N <= 780)
			answer = "Red";
		else if (N >= 590 && N < 620)
			answer = "Orange";
		else if (N >= 570 && N < 590)
			answer = "Yellow";
		else if (N >= 495 && N < 570)
			answer = "Green";
		else if (N >= 450 && N < 495)
			answer = "Blue";
		else if (N >= 425 && N < 450)
			answer = "Indigo";
		else
			answer = "Violet";

		bw.write(answer);

		bw.flush();
		bw.close();
	}
}
