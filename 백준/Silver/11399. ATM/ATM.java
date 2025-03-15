import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 백준 11399번. ATM

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int N = Integer.parseInt(br.readLine());
		input = br.readLine().split(" ");

		int[] array = new int[N];

		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(array);

		int answer = 0;
		int nums = N;
		for (int i = 0; i < N; i++) {
			answer += (array[i] * nums--);
		}

		System.out.println(answer);
	}

}
