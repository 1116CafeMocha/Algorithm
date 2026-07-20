class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        int[] answer = new int[arr.length-1];
        
        int min = Integer.MAX_VALUE;
        int idx = 0, minIdx = 0;
        for(int i=0; i<arr.length; i++) if(arr[i] < min) {min = arr[i]; minIdx = i;}
        for(int i=0; i<arr.length; i++) {if(i==minIdx) continue; answer[idx++] = arr[i];}
        
        return answer;
    }
}