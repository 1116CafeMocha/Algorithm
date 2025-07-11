import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static class Student {
		String name;
		int day;
		int month;
		int year;

		Student(String name, int day, int month, int year) {
			this.name = name;
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		Student max = new Student("max", -1, -1, -1);
		Student min = new Student("min", Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			Student now = new Student(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]),
					Integer.parseInt(input[3]));

			if (now.year > max.year) {
				max = now;
			} else if (now.year == max.year) {
				if (now.month > max.month) {
					max = now;
				} else if (now.month == max.month) {
					if (now.day > max.day) {
						max = now;
					}
				}
			}

			if (now.year < min.year) {
				min = now;
			} else if (now.year == min.year) {
				if (now.month < min.month) {
					min = now;
				} else if (now.month == min.month) {
					if (now.day < min.day) {
						min = now;
					}
				}
			}

		}
		bw.write(max.name);
		bw.newLine();
		bw.write(min.name);

		bw.flush();
		bw.close();
	}
}
