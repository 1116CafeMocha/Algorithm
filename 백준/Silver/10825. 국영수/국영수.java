import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static class Student {
		String name;
		int lan;
		int eng;
		int mth;

		public Student(String name, int lan, int eng, int mth) {
			this.name = name;
			this.lan = lan;
			this.eng = eng;
			this.mth = mth;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		Student[] arr = new Student[N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			String name = input[0];
			int lan = Integer.parseInt(input[1]);
			int eng = Integer.parseInt(input[2]);
			int mth = Integer.parseInt(input[3]);

			arr[i] = new Student(name, lan, eng, mth);
		}

		Arrays.sort(arr, (a, b) -> {
			if (a.lan != b.lan) {
				return b.lan - a.lan;
			}
			if (a.eng != b.eng) {
				return a.eng - b.eng;
			}
			if (a.mth != b.mth) {
				return b.mth - a.mth;
			}

			return a.name.compareTo(b.name);
		});

		for (int i = 0; i < N; i++) {
			bw.write(arr[i].name + "\n");
		}

		bw.flush();
		bw.close();
	}

}
