import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            int n = st.countTokens();
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = st.nextToken();
            }

            out.append("Case #").append(tc).append(": ");
            for (int i = n - 1; i >= 0; i--) {
                out.append(words[i]);
                if (i != 0) out.append(' ');
            }
            out.append('\n');
        }

        System.out.print(out);
	}

}