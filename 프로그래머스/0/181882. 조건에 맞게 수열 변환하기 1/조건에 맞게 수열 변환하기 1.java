import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = Arrays.copyOf(arr, arr.length);
        for(int i=0; i<arr.length; i++){
            int now = answer[i];
            if(now >= 50 && now % 2 == 0) answer[i] = now/2;
            else if(now < 50 && now % 2 != 0) answer[i] = now*2;
        }
        return answer;
    }
}