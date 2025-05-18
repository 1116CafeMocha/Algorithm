import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;

		List<String> listR = new ArrayList<>();
		List<String> listC = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			input = br.readLine().split(" ");

			String nowR = input[0];
			String nowC = input[1];
			
			if (!listR.contains(nowR)) {
				listR.add(nowR);
			}else {
				listR.remove(listR.indexOf(nowR));
			}
			
			if (!listC.contains(nowC)) {
				listC.add(nowC);
			}else {
				listC.remove(listC.indexOf(nowC));
			}
		}
		
		bw.write(listR.get(0) + " " + listC.get(0));

		bw.flush();
		bw.close();
	}
}