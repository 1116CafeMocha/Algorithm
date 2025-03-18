// 백준 1094번. 막대기

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();

		List<Integer> list = new ArrayList<>();
		list.add(64);

		while (!list.isEmpty()) {
			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				sum += list.get(i);
			}

			if (sum == X) {
				System.out.println(list.size());
				break;
			}

			if (sum < X)
				break;

			int now = list.get(0);
			list.remove(0);
			if (sum - now + (now / 2) >= X) {
				list.add(now / 2);
			} else {
				list.add(now / 2);
				list.add(now / 2);
			}

			Collections.sort(list);
		}

	}
}
