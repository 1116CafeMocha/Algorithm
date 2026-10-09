import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int L = nums.length/2;
        for(int num : nums) set.add(num);
        return set.size() >= L ? L : set.size();
    }
}