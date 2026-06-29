import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int[] arr = Arrays.copyOf(citations, citations.length);
        int answer = arr.length;
        Arrays.sort(arr);
        
        for(int i=arr.length-1; i>=0; i--)
            if(arr[i] < arr.length - i) return arr.length - i - 1;
        
        return answer;
    }
}