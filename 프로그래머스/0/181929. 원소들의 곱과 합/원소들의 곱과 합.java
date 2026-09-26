import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        return Math.pow(Arrays.stream(num_list).sum(), 2) > Arrays.stream(num_list).reduce(1, (a, b) -> a*b) ? 1 : 0;
    }
}