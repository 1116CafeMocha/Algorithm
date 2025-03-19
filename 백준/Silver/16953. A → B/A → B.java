// 백준 16953번. A -> B

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long A = sc.nextLong();
		long B = sc.nextLong();
		int count = 1;

		Queue<Long> que = new LinkedList<>();
		HashSet<Long> visited = new HashSet<>();

		que.add(A);
		visited.add(A);

		if (A == B) {
			System.out.println(1);
			return;
		}

		while (!que.isEmpty()) {
			int queSize = que.size();

			count++;
			for (int i = 0; i < queSize; i++) {
				Long now = que.poll();

				Long caseA = now * 2;
				Long caseB = now * 10 + 1;

				if (caseA == B || caseB == B) {
					System.out.println(count);
					return;
				}

				if (!visited.contains(caseA) && caseA < B) {
					visited.add(caseA);
					que.add(caseA);
				}
				if (!visited.contains(caseB) && caseB < B) {
					visited.add(caseB);
					que.add(caseB);
				}
			}
		}

		System.out.println(-1);

		sc.close();
	}

}
