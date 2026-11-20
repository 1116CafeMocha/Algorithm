import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // HashMap에 옷 종류별로 개수 카운팅
        Map<String, Integer> map = new HashMap<>();
        for(String[] now : clothes) map.put(now[1], map.getOrDefault(now[1], 0) + 1);
        
        for(int now : map.values()) answer *= now+1;
        
        return answer-1;
    }
}