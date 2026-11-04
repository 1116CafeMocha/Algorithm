class Solution {
    public int solution(int n, String control) {
        for(int i=0; i<control.length(); i++){
            char order = control.charAt(i);
            
            if(order == 'w') n++;
            else if(order == 's') n--;
            else if(order == 'd') n+=10;
            else n-=10;
            
        }
        
        return n;
    }
}