

class Solution {
    static int max = 1000000;
    
    public int solution(int n) {
        int answer = 0;
        
        boolean[] sosu = new boolean[max + 1];
        for(int i=2; i<=max; i++) {
            for(int j=i+i; j<=max; j+=i) sosu[j] = true;
        }
        
        for(int i=2; i<=n; i++) if(!sosu[i]) answer++;
        
        return answer;
    }
}