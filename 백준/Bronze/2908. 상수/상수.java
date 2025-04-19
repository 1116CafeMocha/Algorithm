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
		String[] strA = input[0].split("");
		String[] strB = input[1].split("");

		int A = Integer.valueOf(strA[2] + strA[1] + strA[0]);
		int B = Integer.valueOf(strB[2] + strB[1] + strB[0]);

		bw.write(Math.max(A, B) + "");

		bw.flush();
		bw.close();
	}
}