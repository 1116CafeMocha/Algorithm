import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int[] nums = new int[6];
		for (int i = 0; i < 6; i++) {
			nums[i] = Integer.parseInt(input[i]);
		}

		loop: for (int x = -999; x <= 999; x++) {
			for (int y = -999; y <= 999; y++) {
				if (nums[0] * x + nums[1] * y == nums[2] && nums[3] * x + nums[4] * y == nums[5]) {
					bw.write(x + " " + y);
					break loop;
				}
			}
		}

		bw.flush();
		bw.close();
	}
}
