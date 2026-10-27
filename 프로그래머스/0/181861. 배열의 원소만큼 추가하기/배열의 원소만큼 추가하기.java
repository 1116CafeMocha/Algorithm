import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int now : arr) for(int i=0; i<now; i++) list.add(now);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}