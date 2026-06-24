class Solution {
    public int solution(int n) {
        int N = n;
        int count = Integer.bitCount(n);
        while(N<=1000000){
            N++;
            if(Integer.bitCount(N) == count) break;
        }
        return N;
    }
}