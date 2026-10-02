// 아래로 이동. 두 가지 선택지. -> 거꾸로 올라가면서 dp

class Solution {
    public int solution(int[][] triangle) {
        int L = triangle.length;
        
        // 2차원 배열 쓰지 않고도 1차원 배열 하나를 계속 갱신하면서 쓸 수 있음!
        int[] dp = triangle[L-1].clone();
        
        for(int r=L-2; r>=0; r--) 
            for(int c=0; c<=r; c++)
                dp[c] = triangle[r][c] + Math.max(dp[c], dp[c+1]);
        
        return dp[0];
    }
}