import java.util.*;

class Solution {
    public String solution(String[] seoul) {
        // return "김서방은 " + Arrays.binarySearch(seoul, "Kim") + "에 있다";
        
        for(int i=0; i<seoul.length; i++) if(seoul[i].contains("Kim")) return "김서방은 " + i + "에 있다";
        
        return "";
    }
}