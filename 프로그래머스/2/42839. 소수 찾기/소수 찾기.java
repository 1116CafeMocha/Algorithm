import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        
        dfs("", numbers);
        
        int answer = 0;
        
        for(int now : set) if(isSosu(now)) answer++;
        
        return answer;
    }
    
    private void dfs(String now, String numbers){
        if(!now.isEmpty()) set.add(Integer.parseInt(now));
        
        for(int i=0; i<numbers.length(); i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            
            // 문자열에 다음 문자 붙여서 넘기기
            dfs(now + numbers.charAt(i), numbers);
            
            // 백트래킹까지 해줌
            visited[i] = false;
        }
    }
    
    private boolean isSosu(int number){
        if(number < 2) return false;
        
        for(int i=2; i*i <= number; i++) if(number % i == 0) return false;
        
        // 소수임
        return true;
    }
}