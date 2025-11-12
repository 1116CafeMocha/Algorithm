import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder out = new StringBuilder();
	static long count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		hanoiD(N, 'A', 'D', 'C', 'B');

		System.out.println(count);
		System.out.println(out.toString());

	}

	static void move(char a, char b) {
		out.append(a).append(' ').append(b).append('\n');
		count++;
	}

	static void hanoi(int n, char from, char to, char aux) {
		if (n == 0)
			return;

		hanoi(n - 1, from, aux, to);
		move(from, to);
		hanoi(n - 1, aux, to, from);
	}

	static void hanoiD(int n, char from, char d, char rest1, char rest2) {
		if (n == 0)
			return;
		
		if (n == 1) {
			move(from, d);
			return;
		}

		if (n == 2) {
			move(from, rest2);
			move(from, d);
			move(rest2, d);
			return;
		}

		hanoi(n - 2, from, rest1, rest2);

		move(from, rest2);

		move(from, d);

		move(rest2, d);

		hanoiD(n - 2, rest1, d, from, rest2);
	}
}
