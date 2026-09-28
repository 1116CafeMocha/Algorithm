// 그래프가 주어진 DFS 문제. 

class Solution {
    int N, answer;
    boolean[] visited;
    int[][] map;
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        N = n;
        visited = new boolean[n];
        map = computers;
        
        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            dfs(i);
            answer++;
        }
        
        return answer;
    }
    
    void dfs(int now){
        visited[now] = true;
        
        for(int i=0; i<N; i++){
            if(map[now][i] == 0) continue;
            if(visited[i]) continue;
            
            dfs(i);
        }
    }
}