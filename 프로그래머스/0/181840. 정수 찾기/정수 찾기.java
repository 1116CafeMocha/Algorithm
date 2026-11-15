import java.util.*;

class Solution {
    public int solution(int[] num_list, int n) {
        if(Arrays.stream(num_list).anyMatch(a -> a == n)) return 1;
        else return 0;
    }
}