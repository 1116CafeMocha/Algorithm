import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int left = 0; 
        int right = people.length-1;
        
        while(left<=right){
            int l = people[left];
            int r = people[right];
            
            if(l + r <= limit) left++;
            
            right--;
            answer++;
        }
        
        return answer;
    }
}