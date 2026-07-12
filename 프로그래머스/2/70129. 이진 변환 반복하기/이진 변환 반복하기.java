import java.util.*;

class Solution {
    static int countToBinary, countZero;
    public int[] solution(String s) { 
        countToBinary = 0;
        countZero = 0;
        while(!s.equals("1")) {
            s = toBinary(s); 
            countToBinary++;
        }
        return new int[] {countToBinary, countZero};
    }
    
    public static String toBinary(String input) {
        int len = input.length();
        int count = 0;
        for(int i=0; i<len; i++) if(input.charAt(i) == '1') count++;
        countZero += len - count;
        return Integer.toBinaryString(count);
    }
}