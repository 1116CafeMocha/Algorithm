class Solution {
    public int solution(String t, String p) {
        int count = 0;
        long P = Long.parseLong(p);
        int L = p.length();
        for(int i=0; i<=t.length()-L; i++) if(Long.parseLong(t.substring(i, i+L)) <= P) count++;
        
        return count;
    }
}