class Solution {
    public String solution(String[] str_list, String ex) {
        StringBuilder sb = new StringBuilder();
        for(String now : str_list) if(!now.contains(ex)) sb.append(now);
        return sb.toString();
    }
}