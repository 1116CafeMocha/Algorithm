// 백준 1094번. 막대기

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();

		int sum = 64;
		int min = 64;
		int num = 1;

		while (true) {
			if (sum == X) {
				System.out.println(num);
				break;
			}

			if (sum < X)
				break;

			int now = min;
			if (sum - now + (now / 2) >= X) {
				sum -= min / 2;
				min /= 2;
			} else {
				min /= 2;
				num++;
			}
		}

	}
}
