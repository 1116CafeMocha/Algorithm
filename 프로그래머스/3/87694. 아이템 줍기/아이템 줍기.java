// 1. 지형의 테두리 확인 : 그냥 boolean 맵에서 먼저 도형 다 true로 채워버리고, 각 도형의 속 부분에 해당하는 걸 싹 false처리해서 지워주면 되는 거 아닌가? 더 좋은 방법이 있을까?
// 2. 테두리에서만 이동 가능하다면, 결국 시작 지점에서 위냐 아래냐 이런 두 가지 경로만 있는 거 아닌가?
// 3. 도형 속 비울때 내부 길이가 1일 경우 예외처리 할 것.
// 이후 bfs 돌려서 답 리턴!

// 결과 : 발상은 괜찮았는데, 이렇게만 구현했더니 변이 맞닿은 경우 이게 실제로는 떨어져 있는건데 맵에는 붙어있는 것처럼 저장되는 문제가 생김... => 애초에 모든 길이를 2배로 늘려서 저장하고 다뤄서 해결.

import java.util.*;

class Solution {
    static int itemR, itemC;
    static int answer;
    static boolean[][] map;
    static boolean[][] visited;
    static Queue<int[]> que;
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        answer = 0;
        
        itemR = itemY * 2;
        itemC = itemX * 2;
        map = new boolean[101][101];
        visited = new boolean[101][101];
        que = new ArrayDeque<>();
        
        // 맵에 직사각형 그리기
        for(int i=0; i<rectangle.length; i++){
            int lx = rectangle[i][0] * 2;
            int ly = rectangle[i][1] * 2;
            int rx = rectangle[i][2] * 2;
            int ry = rectangle[i][3] * 2;
            
            fillRectangle(lx, ly, rx, ry, true);
            saveInnerPart(lx, ly, rx, ry);
        }
        
        for(int[] now : que) fillRectangle(now[0], now[1], now[2], now[3], false);
        
        que.clear();
        visited[characterY * 2][characterX * 2] = true;
        que.offer(new int[]{characterY * 2, characterX * 2});
        bfs();
        
        // for(int r=0; r<101; r++) {
        //     for(int c=0; c<101; c++) System.out.print(map[r][c] == true ? 1 : 0);
        //     System.out.println();
        // }
        
        return answer;
    }
    
    // 맵에 직사각형 채우기 (좌측하단x, 좌측하단y, 우측상단x, 우측상단y, 채울 값)
    void fillRectangle(int lx, int ly, int rx, int ry, boolean val){
        for(int r = ly; r<=ry; r++) 
            for(int c=lx; c<=rx; c++) 
                map[r][c] = val;
    }
    
    // 속부분 좌표 저장 (좌측하단x, 좌측하단y, 우측상단x, 우측상단y)
    void saveInnerPart(int lx, int ly, int rx, int ry){
        // 애초에 전부 2배 해버려서 문제 될 일이 없어짐!!
        // if(rx - lx >= 2 && ry - ly >= 2)
        //     que.offer(new int[]{lx+1, ly+1, rx-1, ry-1});
        
        que.offer(new int[]{lx+1, ly+1, rx-1, ry-1});
    }
    
    // bfs
    void bfs(){
        int count = 0;
        while(!que.isEmpty()){
            int size = que.size();
            count++;
            for(int q = 0; q<size; q++){
                int[] now = que.poll();
                int nowR = now[0];
                int nowC = now[1];
                
                for(int i=0; i<4; i++){
                    int R = nowR + dr[i];
                    int C = nowC + dc[i];
                    
                    if(R <= 0) continue;
                    if(C <= 0) continue;
                    if(R > 100) continue;
                    if(C > 100) continue;
                    if(!map[R][C]) continue;
                    if(visited[R][C]) continue;
                    
                    if(R == itemR && C == itemC){
                        answer = count / 2;
                        return;
                    }
                    
                    visited[R][C] = true;
                    que.offer(new int[]{R, C});
                }
            }
        }
    }
    
}