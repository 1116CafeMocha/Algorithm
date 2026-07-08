import java.util.*;

class Solution {
    public int[] solution(long n) {
        int len = Long.toString(n).length();
        int[] arr = new int[len];
        int idx = 0;
        while(idx < len){
            arr[idx++] = (int) (n % 10);
            n /= 10;
        }
        return arr;
    }
}