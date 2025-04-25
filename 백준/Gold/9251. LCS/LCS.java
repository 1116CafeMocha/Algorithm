import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str1st = br.readLine().split("");
		String[] str2nd = br.readLine().split("");

		int[][] dp = new int[str1st.length + 1][str2nd.length + 1];

		for (int r = 1; r < str1st.length + 1; r++) {

			for (int c = 1; c < str2nd.length + 1; c++) {
				if (str1st[r - 1].equals(str2nd[c - 1])) {
					dp[r][c] = dp[r - 1][c - 1] + 1;
				} else {
					dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
				}
			}
		}
		bw.write(dp[str1st.length][str2nd.length] + "");
		
		bw.flush();
		bw.close();
	}

}
