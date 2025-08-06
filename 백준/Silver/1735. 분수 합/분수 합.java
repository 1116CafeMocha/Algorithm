import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static int gcd(int a, int b) {
		while (b != 0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] A = new int[2];
		int[] B = new int[2];

		for (int i = 0; i < 2; i++) {
			String[] input = br.readLine().split(" ");
			A[i] = Integer.parseInt(input[0]);
			B[i] = Integer.parseInt(input[1]);
		}

		int sumA = A[0] * B[1] + B[0] * A[1];
		int sumB = B[0] * B[1];

		int gcd = gcd(sumA, sumB);

		bw.write(sumA / gcd + " " + sumB / gcd);

		bw.flush();
		bw.close();
	}
}
