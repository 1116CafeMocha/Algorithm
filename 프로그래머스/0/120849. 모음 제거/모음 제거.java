import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        List<Character> list = List.of('a','e','i','o','u');
        char[] arr = my_string.toCharArray();
        for(char now : arr) if(!list.contains(now)) sb.append(now);
        return sb.toString();
    }
}