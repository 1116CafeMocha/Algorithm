import java.util.*;

class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        
        int sum = 0;
        int time = 0;
        
        for(int i=0; i<speeds.length; i++){
            int nowS = speeds[i];
            int nowP = progresses[i] + time * nowS;
            
            if(time == 0){
                time += (100 - nowP + nowS - 1) / nowS;
                sum++;
                if(i == speeds.length - 1) list.add(sum);
                continue;
            }
            
            if(nowP < 100){
                list.add(sum);
                time += (100 - nowP + nowS - 1) / nowS;
                sum = 1;
            }else{
                sum++;
            }
            
            if(i == speeds.length - 1) list.add(sum);
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) answer[i] = list.get(i);
        
        return answer;
    }
}