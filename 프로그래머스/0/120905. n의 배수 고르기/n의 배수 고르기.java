import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        for(int now : numlist) if(now % n == 0) list.add(now);
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}