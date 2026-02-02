import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	static class Problem {
		int num;
		int score;
		Problem(int num, int score){
			this.num = num;
			this.score = score;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Problem[] arr = new Problem[8];
		
		for(int i=0; i<8; i++) {
			int score = Integer.parseInt(br.readLine());
			arr[i] = new Problem(i+1, score);
		}
		
		Arrays.sort(arr, (a, b) -> {
			if(a.score != b.score) return b.score - a.score;
			return a.num - b.num;
		});
		
		Problem[] answer = new Problem[5];
		int sum = 0;
		for(int i=0; i<5; i++) {
			answer[i] = arr[i];
			sum += arr[i].score;
		}
		Arrays.sort(answer, (a, b) -> {
			if(a.num != b.num) return a.num - b.num;
			return b.score - a.score;
		});
		
		bw.write(Integer.toString(sum));
		bw.newLine();
		for(Problem now : answer) bw.write(now.num + " ");
		
		bw.flush();
		bw.close();
	}
}