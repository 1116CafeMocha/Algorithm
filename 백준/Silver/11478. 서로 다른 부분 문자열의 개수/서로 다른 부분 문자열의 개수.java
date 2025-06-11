import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static char[] arr;
	static Set<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();

		arr = input.toCharArray();

		set = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			make(i);
		}

		bw.write(Integer.toString(set.size()));

		bw.flush();
		bw.close();
	}

	static void make(int idx) {
		if (idx > arr.length)
			return;

		String now = Character.toString(arr[idx]);
		for (int i = idx; i < arr.length; i++) {
			now += Character.toString(arr[i]);
			set.add(now);
		}
	}
}
