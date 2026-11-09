class Solution {
    public int[] solution(int brown, int yellow) {
        int yx = yellow, yy = 0;
        
        while(yx>=yy){
            if(yellow % ++yy != 0) continue;
            
            yx = yellow / yy;
            
            if((yx+2)*(yy+2) == brown + yellow) return new int[]{yx+2, yy+2};
        }
        
        return new int[]{-1, -1};
    }
}