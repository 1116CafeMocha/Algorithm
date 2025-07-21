import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		BigInteger A = new BigInteger(input[0]);
		BigInteger B = new BigInteger(input[1]);
		BigInteger C = new BigInteger(input[2]);

		BigInteger result = A.modPow(B, C);
		bw.write(result.toString());

		bw.flush();
		bw.close();
	}
}
