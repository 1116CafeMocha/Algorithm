class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        for(int now : array) if(now > height) answer++;
        return answer;
    }
}