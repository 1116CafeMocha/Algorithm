class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] arr = new boolean[10];
        for(int now : numbers) arr[now] = true;
        
        for(int i=0; i<10; i++) if(!arr[i]) answer += i;
        return answer;
    }
}