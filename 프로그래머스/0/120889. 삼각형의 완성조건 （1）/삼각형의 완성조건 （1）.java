class Solution {
    public int solution(int[] sides) {
        int MAX = 0, rem = 0;
        for(int now : sides) if(now > MAX) MAX = now;
        rem = sides[0] + sides[1] + sides[2] - MAX;
        return MAX < rem ? 1 : 2;
    }
}