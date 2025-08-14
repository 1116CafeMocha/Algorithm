import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int W = Integer.parseInt(input[1]);
		int H = Integer.parseInt(input[2]);
		int L = Integer.parseInt(input[3]);

		int answer = (W / L) * (H / L);
		bw.write(Integer.toString(answer < N ? answer : N));

		bw.flush();
		bw.close();
	}
}
