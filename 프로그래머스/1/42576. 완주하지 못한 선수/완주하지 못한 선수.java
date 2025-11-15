import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) throws IOException {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String now : participant){
            map.put(now, map.getOrDefault(now, 0) + 1);
        }
        
        for(String now : completion){
            if(map.get(now) <= 1){
                map.remove(now);
            }else{
                map.put(now, map.get(now) - 1);
            }
        }
        
        for(String now : map.keySet()){
            if(map.get(now) >= 1){
                answer = now;
                break;
            }
        }
        
        return answer;
    }
}