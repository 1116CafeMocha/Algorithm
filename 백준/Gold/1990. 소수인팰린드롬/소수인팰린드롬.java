import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 첫 풀이 : 소수 먼저 만들고, 주어진 범위 내로 하나씩 팰린드롬인지 확인.
// => 일단 합격은 했지만 메모리, 성능 면에서 문제가 있음... (메모리 : 393740KB, 시간 : 1536ms)
// => 개선하자!
// 1. 짝수 자릿수 팰린드롬은 11을 제외하면 모두 11의 배수이므로 소수가 될 수 없음.
// 2. 팰린드롬의 개수가 적다는 것을 이용하는 문제임!!
// 3. max만큼 다 만들 필요 없음.

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[] base = { 2, 3, 5, 7, 11 };
		for (int num : base) {
			if (A <= num && num <= B) {
				bw.write(num + "\n");
			}
		}

		// 3자리 이상 홀수 자릿수 팰린드롬 생성
		for (int i = 10;; i++) {
			int palindrome = makePalindrome(i);

			if (palindrome > B)
				break;
			if (palindrome < A)
				continue;

			if (isPrime(palindrome)) {
				bw.write(palindrome + "\n");
			}
		}

		bw.write("-1");

		bw.flush();
		bw.close();
	}

	static int makePalindrome(int n) {
		int result = n;
		n /= 10;

		while (n > 0) {
			result = result * 10 + (n % 10);
			n /= 10;
		}

		return result;
	}

	static boolean isPrime(int n) {
		if (n < 2)
			return false;
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;

		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

}