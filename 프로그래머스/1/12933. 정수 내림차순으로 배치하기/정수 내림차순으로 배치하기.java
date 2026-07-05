import java.util.*;

class Solution {
    public long solution(long n) {
        char[] arr = Long.toString(n).toCharArray();
        Arrays.sort(arr);
        return Long.parseLong(new StringBuilder(String.valueOf(arr)).reverse().toString());
    }
}