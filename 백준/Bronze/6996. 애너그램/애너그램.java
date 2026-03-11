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

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if (isAnagram(a, b)) {
                bw.write(a + " & " + b + " are anagrams.\n");
            } else {
                bw.write(a + " & " + b + " are NOT anagrams.\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i) - 'a']++;
            count[b.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }

        return true;
    }
}