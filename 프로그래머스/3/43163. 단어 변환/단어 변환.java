// BFS로 최소경로 시간 리턴
// words 배열에 있는 단어로만 이동 가능
// 한 번에 한 개의 알파벳만 바꿀 수 있음... 
// -> 다음으로 이동 가능한 단어인지 (알파벳 한 개만 다른지) 확인하는 메서드 필요

import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        int count = 0;
        Queue<String> que = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        
        que.offer(begin);
        
        while(!que.isEmpty()){
            int size = que.size();
            
            for(int i=0; i<size; i++){
                String now = que.poll();
                
                if(now.equals(target)) return count;
                
                for(int j=0; j<words.length; j++){
                    if(visited[j]) continue;
                    
                    if(check(now, words[j])){
                        visited[j] = true;
                        que.offer(words[j]);
                    }
                }
            }
            count++;
        }
        
        return 0;
    }
    
    // 이동 가능한 문자열인지 확인! (한 글자만 다른가?)
    boolean check(String str1, String str2){
        int cnt = 0;
        
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)) cnt++;
            
            if(cnt > 1) return false;
        }
        
        if(cnt == 1) return true;
        return false;
    }
}