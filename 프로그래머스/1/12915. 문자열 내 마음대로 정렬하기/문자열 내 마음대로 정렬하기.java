import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = Arrays.copyOf(strings, strings.length);
        Arrays.sort(answer, (a, b) -> {
            if(a.charAt(n) == b.charAt(n)) return a.compareTo(b);
            return Character.compare(a.charAt(n), b.charAt(n));
        });
        return answer;
    }
}