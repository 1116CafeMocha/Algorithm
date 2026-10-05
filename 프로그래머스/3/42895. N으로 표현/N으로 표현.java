// dp[i] = N을 i번 써서 만들 수 있는 모든 수
// N+N
// N-N
// N*N
// N/N
// NNNNN...
// N을 9번 이상 쓰게 되면 -1 리턴!
import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        List<Set<Integer>> dp = new ArrayList<>();
        
        // 초기화
        for(int i=0; i<9; i++) dp.add(new HashSet<>());
        
        for(int i=1; i<9; i++){
            int NN = Integer.parseInt(String.valueOf(N).repeat(i));
            
            dp.get(i).add(NN);
            
            for(int j=1; j<i; j++){
                
                for(int a : dp.get(j)){
                    for(int b : dp.get(i-j)){
                        dp.get(i).add(a+b);
                        dp.get(i).add(a-b);
                        dp.get(i).add(a*b);
                        
                        if(b != 0) dp.get(i).add(a/b);
                    }
                }
            }
            
            if(dp.get(i).contains(number)) return i;
        }
        
        return -1;
    }
}