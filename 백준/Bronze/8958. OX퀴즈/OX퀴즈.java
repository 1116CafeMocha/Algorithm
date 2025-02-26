import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 8958번 OX 퀴즈

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input;

		int N = Integer.parseInt(br.readLine());

		for (int testcase = 0; testcase < N; testcase++) {
			input = br.readLine().split("");
			int now = 0;
			int answer = 0;
			for (int i = 0; i < input.length; i++) {
				if (input[i].equals("O")) {
					now++;
				}
				if (input[i].equals("X") || i == input.length - 1) {
					for (int k = 1; k <= now; k++) {
						answer += k;
					}
					now = 0;
				}
			}
			System.out.println(answer);
		}

	}

}
