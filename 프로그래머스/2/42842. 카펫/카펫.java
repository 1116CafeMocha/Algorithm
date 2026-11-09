class Solution {
    public int[] solution(int brown, int yellow) {
        
        for(int yy=1; yy*yy<=yellow; yy++){
            if(yellow % yy != 0) continue;
            
            int yx = yellow / yy;
            
            if((yx+2)*(yy+2) == brown + yellow) return new int[]{yx+2, yy+2};
        }
        
        return new int[]{-1, -1};
    }
}