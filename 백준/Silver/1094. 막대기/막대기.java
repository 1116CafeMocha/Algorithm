// 백준 1094번. 막대기
// 2의 거듭제곱들의 합으로 X를 표현하는 것과 같다!

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();

		System.out.println(Integer.bitCount(X));
	}
}
