import java.util.*;

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        int len = s.length();
        
        if(len % 2 == 0){
            return new String(new char[] {arr[len/2-1], arr[len/2]});
        }else{
            return Character.toString(arr[len/2]);
        }
    }
}