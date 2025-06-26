import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		char[] arr = input.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if (Character.isLowerCase(arr[i])) {
				arr[i] = Character.toUpperCase(arr[i]);
			} else {
				arr[i] = Character.toLowerCase(arr[i]);
			}
		}

		for (Character now : arr) {
			bw.write(now);
		}

		bw.flush();
		bw.close();
	}

}
