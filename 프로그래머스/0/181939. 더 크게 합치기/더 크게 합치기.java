class Solution {
    public int solution(int a, int b) {
        return sum(a,b) == sum(b,a) ? sum(a,b) : Math.max(sum(a,b), sum(b,a));
    }
    
    int sum(int a, int b){
        return a*((int)Math.pow(10, ((int)Math.log10(b)+1)))+b;
    }
}