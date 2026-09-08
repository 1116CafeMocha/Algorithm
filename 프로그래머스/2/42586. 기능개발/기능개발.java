import java.util.*;

class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        
        int sum = 0;
        int time = 0;
        
        for(int i=0; i<speeds.length; i++){
            int now = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            
            if(now > time){
                if(sum > 0) list.add(sum);
                
                time = now;
                sum = 1;
            }else{
                sum++;
            }
        }
        list.add(sum);
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) answer[i] = list.get(i);
        
        return answer;
    }
}