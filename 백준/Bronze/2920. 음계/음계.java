import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int[] arr = new int[9];

		for (int i = 1; i <= 8; i++) {
			arr[i] = Integer.parseInt(input[i - 1]);
		}

		if (arr[1] == 8) {
			for (int i = 8; i >= 1; i--) {
				if (arr[9 - i] != i) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("descending");
		} else if (arr[1] == 1) {
			for (int i = 1; i <= 8; i++) {
				if (arr[i] != i) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("ascending");
		} else {
			System.out.println("mixed");
		}

	}

}
