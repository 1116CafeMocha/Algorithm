import java.util.*;

class Solution {
    static int N, M, answer;
    static boolean[][] map, visited;
    static Queue<int[]> que;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        answer = -1;
        N = maps.length;
        M = maps[0].length;
        
        map = new boolean[N][M];
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++)
                if(maps[r][c] == 0) map[r][c] = true;
        }
        
        visited = new boolean[N][M];
        visited[0][0] = true;
        
        que = new ArrayDeque<>();
        que.offer(new int[] {0, 0});
        
        bfs();
        
        if(answer == 0) return -1;
        return answer;
    }
    
    static void bfs(){
        int count = 0;
        loop: while(!que.isEmpty()){
            count++;
            int size = que.size();
            
            for(int i=0; i<size; i++){
                int[] now = que.poll();
                int nowR = now[0];
                int nowC = now[1];
                
                for(int j=0; j<4; j++){
                    int nextR = nowR + dr[j];
                    int nextC = nowC + dc[j];
                    
                    if(nextR == N-1 && nextC == M-1){
                        answer = count + 1;
                        return;
                    }
                    
                    if(nextR < 0) continue;
                    if(nextC < 0) continue;
                    if(nextR >= N) continue;
                    if(nextC >= M) continue;
                    if(map[nextR][nextC]) continue;
                    if(visited[nextR][nextC]) continue;
                    
                    visited[nextR][nextC] = true;
                    que.offer(new int[]{nextR, nextC});
                }
            }
        }
    }
}