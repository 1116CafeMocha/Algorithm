import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = 1000-Integer.parseInt(br.readLine());
        int answer = 0;
        
        int[] coins = {500, 100, 50, 10, 5, 1};
        
        for(int i=0; i<6; i++){
            int coin = coins[i];
            
            answer += money/coin;
            money %= coin;
        }
        
        System.out.print(answer);
    }
}