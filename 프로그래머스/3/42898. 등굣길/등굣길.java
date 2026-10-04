// 격자에서 오른쪽과 아래쪽으로만 움직일 수 있음 -> 이미 모든 경로가 최단경로임!! -> 모든 경로의 수의 합
import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 1;
        
        for(int[] now : puddles) dp[now[1]][now[0]] = -1;
        
        for(int r=1; r<=n; r++){
            for(int c=1; c<=m; c++){
                if(r==1 && c==1) continue;
                if(dp[r][c]==-1){
                    dp[r][c] = 0;
                    continue;
                }
                
                dp[r][c] = (dp[r-1][c] + dp[r][c-1]) % 1000000007;
            }
        }
        
        return dp[n][m];
    }
}