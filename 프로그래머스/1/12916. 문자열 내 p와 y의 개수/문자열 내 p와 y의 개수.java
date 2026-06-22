class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int countY = 0;
        int countP = 0;
        
        for(int i=0; i<s.length(); i++){
            char now = s.charAt(i);
            if(now == 'p' || now == 'P') countP++;
            else if(now == 'y' || now == 'Y') countY++;
        }
        
        if(countY == countP) answer = true;
        
        return answer;
    }
}