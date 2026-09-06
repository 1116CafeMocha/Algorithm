// 스택 쓰면 될 것 같음.
import java.util.*;

class Solution
{
    Stack<Character> stack;
    public int solution(String s)
    {
        int answer = -1;
        
        stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char now = s.charAt(i);
            
            if(!stack.isEmpty() && stack.peek() == now) stack.pop();
            else stack.add(now);
        }
        
        return stack.isEmpty() == true ? 1 : 0;
    }
}