class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        for(char now : rsp.toCharArray()){
            if(now == '2') sb.append('0');
            else if(now == '0') sb.append('5');
            else sb.append('2');
        }
        return sb.toString();
    }
}