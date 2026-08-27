class Solution {
    public int solution(int[] dot) {
        int X = dot[0];
        int Y = dot[1];
        
        if(X>0 && Y>0) return 1;
        else if (X<0 && Y>0) return 2;
        else if (X<0 && Y<0) return 3;
        else return 4;
    }
}