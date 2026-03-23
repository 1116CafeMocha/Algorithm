import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//		Long N = Long.parseLong(br.readLine(), 8);
//		bw.write(Long.toString(N, 2));

		String input = br.readLine();

		if (input.equals("0")) {
			System.out.println(0);
			return;
		}

		switch (input.charAt(0)) {
		case '1':
			bw.write("1");
			break;
		case '2':
			bw.write("10");
			break;
		case '3':
			bw.write("11");
			break;
		case '4':
			bw.write("100");
			break;
		case '5':
			bw.write("101");
			break;
		case '6':
			bw.write("110");
			break;
		case '7':
			bw.write("111");
			break;
		}

		for (int i = 1; i < input.length(); i++) {
			switch (input.charAt(i)) {
			case '0':
				bw.write("000");
				break;
			case '1':
				bw.write("001");
				break;
			case '2':
				bw.write("010");
				break;
			case '3':
				bw.write("011");
				break;
			case '4':
				bw.write("100");
				break;
			case '5':
				bw.write("101");
				break;
			case '6':
				bw.write("110");
				break;
			case '7':
				bw.write("111");
				break;
			}
		}

		bw.flush();
		bw.close();
	}

}