import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++){
            int I = commands[i][0];
            int J = commands[i][1];
            int K = commands[i][2];
            
            int[] subArr = Arrays.copyOfRange(array, I-1, J);
            Arrays.sort(subArr);
            answer[i] = subArr[K-1];
        }
        
        return answer;
    }
}