import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for(int now : arr) {
            if(que.isEmpty()) {
                que.offer(now);
                continue;
            }
            if(que.peekLast() == now) continue;
            que.offer(now);
        }
        
        int size = que.size();
        
        int[] answer = new int[size];
        for(int i=0; i<size; i++) answer[i] = que.poll();
        
        return answer;
    }
}