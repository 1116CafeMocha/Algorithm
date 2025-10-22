import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static class Applicant {
		int num;
		int document;
		int interview;

		public Applicant(int num, int document, int interview) {
			this.num = num;
			this.document = document;
			this.interview = interview;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int count = 0;
			int N = Integer.parseInt(br.readLine());
			Applicant[] arr = new Applicant[N];

			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				arr[i] = new Applicant(i, Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			}

			Arrays.sort(arr, (a, b) -> {
				return a.document - b.document;
			});

			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				Applicant now = arr[i];
				if (now.interview < min) {
					count++;
					min = now.interview;
				}
			}

			bw.write(Integer.toString(count));
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}

}
