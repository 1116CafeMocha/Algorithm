import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Student {
		int country;
		int student;
		int score;
		
		Student (int country, int student, int score){
			this.country = country;
			this.student = student;
			this.score = score;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Student[] students = new Student[N];
		int[] count = new int[N+1];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			students[i] = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(students, (a, b) -> {
			return b.score - a.score;
		});
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(N == 3 && i == 3) break;
			Student now = students[i];
			if(count[now.country] >= 2) continue;
			if(cnt >= 3) break;
			
			bw.write(now.country + " " + now.student + "\n");
			count[now.country]++;
			cnt++;
		}
		
		bw.flush();
		bw.close();
	}

}