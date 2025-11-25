import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 물병을 다루는 로직이 이진법과 같음!
// 같은 양의 물이 들어 있는 물병을 합치기 = 이진수 자리 올림
// 물병 개수 = 이진수의 1의 개수
// 결국 1의 개수가 K 이하가 되도록 하는 최솟값 찾기!

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if (N <= K) {
			System.out.println("0");
			return;
		}

		int answer = 0;

		while (Integer.bitCount(N) > K) {
			int min = N & -N;
			answer += min;
			N += min;
		}

		bw.write(Integer.toString(answer));

		bw.flush();
		bw.close();
	}

}
