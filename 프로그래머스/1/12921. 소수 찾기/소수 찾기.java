

class Solution {
    
    public int solution(int n) {
        int answer = 0;
        
        boolean[] sosu = new boolean[n + 1];
        for(int i=2; i<=n; i++) {
            for(int j=i+i; j<=n; j+=i) sosu[j] = true;
        }
        
        for(int i=2; i<=n; i++) if(!sosu[i]) answer++;
        
        return answer;
    }
}