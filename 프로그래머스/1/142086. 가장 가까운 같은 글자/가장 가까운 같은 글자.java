import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] count = new int[26];
        Arrays.fill(count, -1);
        for(int i=0; i<s.length(); i++){
            char now = s.charAt(i);
            int idx = now - 'a';
            if(count[idx] == -1) answer[i] = -1;
            else answer[i] = i - count[idx];
            count[idx] = i;
        }
        return answer;
    }
}