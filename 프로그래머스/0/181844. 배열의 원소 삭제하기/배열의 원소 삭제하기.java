import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        Set<Integer> set = new LinkedHashSet<>();
        for(int now : arr) set.add(now);
        for(int now : delete_list) set.remove(now);
        
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}