import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int L = num_list.length;
        int[] answer = Arrays.copyOf(num_list, L+1);
        answer[L] = num_list[L-1] > num_list[L-2] ? num_list[L-1] - num_list[L-2] : num_list[L-1]*2;
        return answer;
    }
}