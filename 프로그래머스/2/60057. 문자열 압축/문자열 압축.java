import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        String str = "";
        
        for(int i=1; i<=s.length()/2; i++){
            int count = 0;
            int stack = 1;
            str = s.substring(0, i);
            
            for(int j=i; j<s.length(); j+=i){
                String now = j+i < s.length() ? s.substring(j, j+i) : s.substring(j, s.length());
                if(str.equals(now)) stack++;
                else{
                    count += str.length();
                    if(stack != 1) count+=Integer.toString(stack).length();
                    str = now;
                    stack = 1;
                }
                
            }
            count += str.length();
            
            if(stack != 1) count+=Integer.toString(stack).length();
            
            answer = Math.min(answer, count);
        }
        
        return answer;
    }
}