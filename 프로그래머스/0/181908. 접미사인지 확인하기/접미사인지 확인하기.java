class Solution {
    public int solution(String my_string, String is_suffix) {
        int len_str = my_string.length();
        int len_suf = is_suffix.length();
        if(len_suf > len_str) return 0;
        if(is_suffix.equals(my_string.substring(len_str-len_suf, len_str))) return 1;
        return 0;
    }
}