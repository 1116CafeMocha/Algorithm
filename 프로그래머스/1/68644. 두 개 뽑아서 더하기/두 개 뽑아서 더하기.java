import java.util.*;

// 원래는 contains 매번 돌리는거보다 set을 쓰는 등 중복체크 해주는게 좋음

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<numbers.length; i++) for(int j=i+1; j<numbers.length; j++) if(!list.contains(numbers[i] + numbers[j]))list.add(numbers[i]+numbers[j]);
        Collections.sort(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}