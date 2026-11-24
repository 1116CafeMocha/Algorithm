import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        int H, W, N;
        
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            
            bw.write(String.valueOf(((N-1)/H+1) + ((N-1)%H+1)*100));
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}