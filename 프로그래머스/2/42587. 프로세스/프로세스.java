import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> que = new ArrayDeque<>();
        for(int i=0; i<priorities.length; i++) que.offer(i);
        
        while(!que.isEmpty()){
            int now = que.poll();
            boolean hasHigher = false;
            
            for(int p : priorities){
                if(p > priorities[now]){
                    hasHigher = true;
                    break;
                }
            }
            
            if(hasHigher) que.offer(now);
            else{
                answer++;
                
                if(now == location) return answer;
                
                priorities[now] = 0;
            }
        }
        
        return answer;
    }
}