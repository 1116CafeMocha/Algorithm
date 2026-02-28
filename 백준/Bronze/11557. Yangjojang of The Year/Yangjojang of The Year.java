import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            String answer = "";
            int max = -1;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String school = st.nextToken();
                int alcohol = Integer.parseInt(st.nextToken());

                if (alcohol > max) {
                    max = alcohol;
                    answer = school;
                }
            }

            bw.write(answer);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}