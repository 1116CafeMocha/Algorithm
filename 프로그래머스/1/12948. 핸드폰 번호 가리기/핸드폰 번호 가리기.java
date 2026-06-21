class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int len = phone_number.length();
        answer = "*".repeat(len-4) + phone_number.charAt(len-4) + phone_number.charAt(len-3) + phone_number.charAt(len-2) + phone_number.charAt(len-1);
        return answer;
    }
}