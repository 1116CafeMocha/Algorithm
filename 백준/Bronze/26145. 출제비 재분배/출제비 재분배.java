import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int NM = N + M;

        long[] result = new long[NM];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            result[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < NM; j++) {
                long t = Long.parseLong(st.nextToken());
                if (t == 0) continue;
                result[i] -= t;
                result[j] += t;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NM; i++) {
            sb.append(result[i]);
            if (i + 1 < NM) sb.append(' ');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}