import java.util.*;

class Solution {
    class Task{
        int progress;
        int speed;
        
        Task(int p, int s){
            this.progress = p;
            this.speed = s;
        }
    }
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        
        Queue<Task> que = new ArrayDeque<>();
        for(int i=0; i<speeds.length; i++) que.offer(new Task(progresses[i], speeds[i]));
        
        int sum = 0;
        int time = 0;
        
        while(!que.isEmpty()){
            Task now = que.poll();
            int nowS = now.speed;
            int nowP = now.progress + time * nowS;
            
            if(time == 0){
                time += (100 - nowP + nowS - 1) / nowS;
                sum++;
                if(que.isEmpty()) list.add(sum);
                continue;
            }
            
            if(nowP < 100){
                list.add(sum);
                time += (100 - nowP + nowS - 1) / nowS;
                sum = 1;
            }else{
                sum++;
            }
            
            if(que.isEmpty()) list.add(sum);
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) answer[i] = list.get(i);
        
        return answer;
    }
}