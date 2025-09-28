import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Set<Character> mo = new TreeSet<>();

		mo.add('a');
		mo.add('e');
		mo.add('i');
		mo.add('o');
		mo.add('u');

		boolean answer;
		boolean flag;
		char now;
		int count;

		while (true) {
			String input = br.readLine();
			if (input.equals("end"))
				break;
			answer = false;
			flag = false;
			count = 1;

			char[] word = input.toCharArray();
			boolean[] check = new boolean[word.length];

			for (int i = 0; i < word.length; i++) {
				if (mo.contains(word[i]))
					check[i] = true;
			}

			// 1번 규칙
			for (char m : mo) {
				if (input.contains(Character.toString(m)))
					flag = true;
			}

			// 나머지 규칙

			now = word[0];

			loop: if (flag) {
				// 한 자리일 경우
				if (word.length == 1) {
					answer = true;
					break loop;
				}

				for (int i = 1; i < word.length; i++) {
					// 2번 규칙
					if (check[i] == check[i - 1])
						count++;
					else
						count = 1;

					if (count >= 3)
						break loop;

					now = word[i];

					// 3번 규칙
					if (now != 'e' && now != 'o') {
						if (now == word[i - 1])
							break loop;

					}
				}

				answer = true;
			}

			bw.write("<" + input + "> is ");
			if (!answer)
				bw.write("not ");
			bw.write("acceptable.\n");
		}

		bw.flush();
		bw.close();
	}

}
