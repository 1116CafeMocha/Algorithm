import java.util.*;

class Solution {
    public String[] solution(String myString) {
        List<String> list = new ArrayList<>();
        for(String s : myString.split("x")) if(!s.isEmpty()) list.add(s);
        Collections.sort(list);
        return list.toArray(new String[0]);
    }
}