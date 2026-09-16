import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        Set<String> set = new HashSet<>(Arrays.asList(s1));
        for(String now : s2) if(set.contains(now)) answer++;
        return answer;
    }
}