import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int MAX=Integer.MIN_VALUE, MIN=Integer.MAX_VALUE;
        for(String str : arr) {
            int now = Integer.parseInt(str);
            MAX = Math.max(MAX, now);
            MIN = Math.min(MIN, now);
        }
        String answer = MIN + " " + MAX;
        return answer;
    }
}