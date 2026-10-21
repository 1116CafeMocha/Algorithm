class Solution {
    int answer;
    int[] number;
    
    public int solution(int[] number) {
        answer = 0;
        this.number = number;
        
        comb(0, 0, 0);
        
        return answer;
    }
    
    void comb(int start, int depth, int sum){
        if(depth == 3) {
            if(sum == 0) answer++;
            return;
        }
        
        for(int i=start; i<number.length; i++)
            comb(i+1, depth+1, sum+number[i]);
        
    }
}