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
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int P = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int T = Integer.parseInt(br.readLine());

		int x = (P + T) % (W * 2);

		if (x > W)
			x = W * 2 - x;

		int y = (Q + T) % (H * 2);

		if (y > H)
			y = H * 2 - y;

		bw.write(x + " " + y);

		bw.flush();
		bw.close();
	}

}
