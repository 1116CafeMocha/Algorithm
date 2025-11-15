import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> set = new HashSet<>();
        
        for(String now : phone_book) set.add(now);
        
        for(String now : phone_book){
            for(int i=0; i<now.length(); i++){
                if(set.contains(now.substring(0, i))){
                    answer = false;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}