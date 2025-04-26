import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split("");
		int len = input.length;
		boolean flag = false;

		for (int i = 0; i < len / 2; i++) {
			if (!input[i].equals(input[len - 1 - i])) {
				flag = true;
				break;
			}
		}

		if (flag)
			bw.write("0");
		else {
			bw.write("1");
		}

		bw.flush();
		bw.close();
	}
}