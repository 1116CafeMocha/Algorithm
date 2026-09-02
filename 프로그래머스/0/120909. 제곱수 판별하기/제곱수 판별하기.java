class Solution {
    public int solution(int n) {
        int num = (int) Math.sqrt(n);
        return num * num == n ? 1 : 2;
    }
}