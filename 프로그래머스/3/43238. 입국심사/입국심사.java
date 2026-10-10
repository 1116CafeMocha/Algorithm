// 우선순위큐로 시뮬돌리기 (n이 작으면) or 이분탐색 
// count = time / t1 + time / t2 ...
// 간단하니까 시뮬 돌리지 않고 그냥 답을 이분탐색으로 찾기

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        // 이분탐색
        long left = 0;
        long right = (long)times[times.length - 1] * n;
        
        while(left <= right){
            long sum = 0;
            long mid = left + (right - left) / 2;
            
            for(int time : times) {
                sum += mid / time;
                if(sum >= n) break;
            }
            
            if(sum >= n) {
                answer = mid; 
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return answer;
    }
}