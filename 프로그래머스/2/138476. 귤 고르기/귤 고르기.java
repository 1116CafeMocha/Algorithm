import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int count = 0;
        int[] arr = new int[10000001];
        for(int now : tangerine) arr[now]++;
        Arrays.sort(arr);
        for(int i = 10000000; i>0; i--){
            answer++;
            count += arr[i];
            if(count >= k) break;
        }
        return answer;
    }
}