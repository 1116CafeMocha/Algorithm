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
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            int x = (int)(a % 10);

            int r = (int)(b % 4);
            if (r == 0) r = 4;

            int ans = 1;
            for (int i = 0; i < r; i++) {
                ans = (ans * x) % 10;
            }

            if (ans == 0) ans = 10;
            bw.write(ans + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
