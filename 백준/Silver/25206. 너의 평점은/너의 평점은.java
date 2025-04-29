import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		double sumGrade = 0;
		double sumCredit = 0;

		for (int i = 0; i < 20; i++) {
			String[] input = br.readLine().split(" ");

			double credit = Double.parseDouble(input[1]);
			String grade = input[2];

			if (grade.equals("P"))
				continue;

			double subjectGrade;

			switch (grade) {
			case "A+":
				subjectGrade = 4.5;
				break;
			case "A0":
				subjectGrade = 4.0;
				break;
			case "B+":
				subjectGrade = 3.5;
				break;
			case "B0":
				subjectGrade = 3.0;
				break;
			case "C+":
				subjectGrade = 2.5;
				break;
			case "C0":
				subjectGrade = 2.0;
				break;
			case "D+":
				subjectGrade = 1.5;
				break;
			case "D0":
				subjectGrade = 1.0;
				break;
			default:
				subjectGrade = 0.0;
				break;
			}

			sumCredit += credit;
			sumGrade += credit * subjectGrade;
		}

		bw.write(String.format("%.6f" , (sumGrade / sumCredit)));

		bw.flush();
		bw.close();
	}
}