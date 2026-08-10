class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        for(int now : numbers) answer += now;
        return answer / numbers.length;
    }
}