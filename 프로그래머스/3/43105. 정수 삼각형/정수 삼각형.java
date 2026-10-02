// 아래로 이동. 두 가지 선택지. -> 거꾸로 올라가면서 dp

class Solution {
    public int solution(int[][] triangle) {
        int L = triangle.length;
        
        int[][] dp = new int[L][L];
        dp[L-1] = triangle[L-1].clone();
        
        for(int r=L-2; r>=0; r--){
            for(int c=0; c<=r; c++){
                dp[r][c] = triangle[r][c] + Math.max(dp[r+1][c], dp[r+1][c+1]);
            }
        }
        
        return dp[0][0];
    }
}