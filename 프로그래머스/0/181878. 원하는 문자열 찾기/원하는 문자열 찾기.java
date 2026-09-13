class Solution {
    public int solution(String myString, String pat) {
        return myString.toUpperCase().contains(pat.toUpperCase()) == true ? 1 : 0;
    }
}