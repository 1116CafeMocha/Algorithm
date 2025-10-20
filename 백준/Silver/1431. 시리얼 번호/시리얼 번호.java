import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		String[] str = new String[N];

		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}

		Arrays.sort(str, (a, b) -> {
			if (a.length() != b.length())
				return a.length() - b.length();

			int A = digitSum(a), B = digitSum(b);

			if (A != B)
				return A - B;

			return a.compareTo(b);
		});

		for (String now : str) {
			bw.write(now + "\n");
		}

		bw.flush();
		bw.close();
	}

	static int digitSum(String S) {
		int sum = 0;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c >= '0' && c <= '9')
				sum += c - '0';
		}

		return sum;
	}
}
