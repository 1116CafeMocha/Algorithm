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
		int count = 0;
		String now, next;
		for (int i = 0; i < input.length; i++) {
			now = input[i];
			if (i == input.length - 1) {
				count++;
				break;
			}
			next = input[i + 1];

			if (now.equals("c")) {
				if (next.equals("=") || next.equals("-")) {
					count++;
					i++;
					continue;
				}
			} else if (now.equals("d")) {
				if (next.equals("z")) {
					if (i < input.length - 2 && input[i + 2].equals("=")) {
						count++;
						i += 2;
						continue;
					}
				} else if (next.equals("-")) {
					count++;
					i++;
					continue;
				}
			} else if (now.equals("l") && next.equals("j")) {
				count++;
				i++;
				continue;
			} else if (now.equals("n") && next.equals("j")) {
				count++;
				i++;
				continue;
			} else if (now.equals("s") && next.equals("=")) {
				count++;
				i++;
				continue;
			} else if (now.equals("z") && next.equals("=")) {
				count++;
				i++;
				continue;
			}

			count++;
		}

		bw.write(count + "");

		bw.flush();
		bw.close();
	}
}