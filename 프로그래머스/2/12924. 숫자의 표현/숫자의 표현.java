class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++){
            int now = i;
            int sum = 0;
            while(sum <= n){ 
                sum += now++;
                if(sum == n) {
                    answer++; 
                    break;
                }
            }
        }
        return answer;
    }
}