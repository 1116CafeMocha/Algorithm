import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) arr[i] = Integer.toString(numbers[i]);
        Arrays.sort(arr, (a, b) -> {
            return (b+a).compareTo(a+b);
        });
        
        if(Integer.parseInt(arr[0]) == 0) return "0"; 
        
        for(String now : arr) answer += now;
        
        return answer;
    }
}