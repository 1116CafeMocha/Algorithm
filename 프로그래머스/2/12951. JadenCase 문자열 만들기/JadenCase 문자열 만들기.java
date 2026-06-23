import java.util.*;

class Solution {
    public String solution(String s) {
        
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i] == ' ') continue;
            
            if(i==0 || (i>0 && arr[i-1] == ' ')){
                if(Character.isDigit(arr[i])) continue;
                arr[i] = Character.toUpperCase(arr[i]);
                continue;
            }
            
            arr[i] = Character.toLowerCase(arr[i]);
        }
        
        return String.valueOf(arr);
    }
}