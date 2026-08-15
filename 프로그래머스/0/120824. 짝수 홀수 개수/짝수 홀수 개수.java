class Solution {
    public int[] solution(int[] num_list) {
        int hol = 0;
        for(int now : num_list) if(now%2!=0) hol++;
        return new int[]{num_list.length - hol, hol};
    }
}