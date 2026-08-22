class Solution {
    public String solution(String my_string) {
        char[] arr = my_string.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i] < 'a') arr[i] += 'a' - 'A';
            else arr[i] -= 'a' - 'A';
        }
        return String.valueOf(arr);
    }
}