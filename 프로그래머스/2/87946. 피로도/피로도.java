class Solution {
    int answer, L;
    int[][] dungeons;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        L = dungeons.length;
        this.dungeons = dungeons;
        
        dfs(k, new boolean[L], 0);
        
        return answer;
    }
    
    void dfs(int k, boolean[] visited, int count){
        if(count > answer) answer = count;
        
        for(int i=0; i<L; i++){
            if(visited[i]) continue;
            
            int min = dungeons[i][0];
            int use = dungeons[i][1];
            
            if(k < min) continue;
            if(k < use) continue;
            
            visited[i] = true;
            dfs(k-use, visited, count+1);
            visited[i] = false;
        }
    }
}