class Solution {
    public int solution(String my_string, String is_suffix) {
        if(is_suffix.length() > my_string.length()) return 0;
        if(is_suffix.equals(my_string.substring(my_string.length()-is_suffix.length(), my_string.length()))) return 1;
        return 0;
    }
}