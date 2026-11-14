class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        for(int k : array) if(k == n) answer++;
        return answer;
    }
}