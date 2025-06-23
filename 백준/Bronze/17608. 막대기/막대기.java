import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int right = arr[N - 1];
		int count = 1;

		for (int i = N - 1; i >= 0; i--) {
			if (arr[i] > right) {
				right = arr[i];
				count++;
			}
		}

		bw.write(Integer.toString(count));

		bw.flush();
		bw.close();
	}

}
