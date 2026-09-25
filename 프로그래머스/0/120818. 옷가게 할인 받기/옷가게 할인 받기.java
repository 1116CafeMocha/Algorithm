class Solution {
    public int solution(int price) {
        return price * (100 - (price >= 500000 ? 20 : price >= 300000 ? 10 : price >= 100000 ? 5 : 0)) / 100;
    }
}