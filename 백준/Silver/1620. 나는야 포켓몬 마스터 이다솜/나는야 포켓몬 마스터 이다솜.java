// 백준 1620번. 나는야 포켓몬 마스터 이다솜

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;
		String str;
		input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		String[] array = new String[N + 1];
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			str = br.readLine();
			array[i] = str;
			map.put(str, i);
		}

		for (int i = 0; i < M; i++) {
			str = br.readLine();
			if (map.containsKey(str))
				bw.write(map.get(str) + "\n");
			else
				bw.write(array[Integer.parseInt(str)] + "\n");
		}

		bw.flush();
		bw.close();
	}

}
