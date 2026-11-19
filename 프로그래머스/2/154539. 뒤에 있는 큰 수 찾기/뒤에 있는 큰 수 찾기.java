import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i=0; i<numbers.length; i++){
            int now = numbers[i];
            
            while(!stack.isEmpty() && now > numbers[stack.peekLast()]){
                answer[stack.pollLast()] = numbers[i];
            }
            
            stack.offerLast(i);
        }
        
        return answer;
    }
}