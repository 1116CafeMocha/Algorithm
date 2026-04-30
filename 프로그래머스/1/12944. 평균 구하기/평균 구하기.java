import java.util.*;

class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for(int now : arr) answer += now;
        answer /= arr.length;
        return answer;
    }
}