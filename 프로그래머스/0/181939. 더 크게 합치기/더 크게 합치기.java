class Solution {
    public int solution(int a, int b) {
        return sum(a,b) == sum(b,a) ? sum(a,b) : Math.max(sum(a,b), sum(b,a));
    }
    
    int sum(int a, int b){
        // 원래는 0 예외처리 해줘야 함!
        return a*((int)Math.pow(10, ((int)Math.log10(b)+1)))+b;
    }
}