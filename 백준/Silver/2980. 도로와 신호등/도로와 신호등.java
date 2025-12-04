import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[][] traffic = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());

			traffic[i][0] = D;
			traffic[i][1] = R;
			traffic[i][2] = G;
		}

		int time = 0;
		int now = 0;

		for (int i = 0; i < N; i++) {
			int nowD = traffic[i][0];
			int nowR = traffic[i][1];
			int nowG = traffic[i][2];

			time += nowD - now;

			int val = time % (nowR + nowG);

			if (val < nowR) {
				time += (nowR - val);
			}

			now = nowD;
		}

		time += L - now;

		bw.write(Integer.toString(time));

		bw.flush();
		bw.close();
	}

}
