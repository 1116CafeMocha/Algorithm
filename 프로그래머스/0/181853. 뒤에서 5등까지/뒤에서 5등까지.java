import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        return new int[]{num_list[0],num_list[1],num_list[2],num_list[3],num_list[4]};
    }
}