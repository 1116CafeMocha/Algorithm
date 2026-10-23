// 0은 빈칸, 1은 채워진 칸
// bfs로 0 영역 확인
// 두 입력 모두 2차원배열 map 형태로 제공됨
// 테이블 위 도형을 모두 (0, 0)에서 시작한것처럼 정규화해서 다루자

import java.util.*;

class Solution {
    int answer, N;
    List<List<int[]>> holes, pieces;
    
    private static final int[] dr = {0, 1, 0, -1};
    private static final int[] dc = {1, 0, -1, 0};
    
    public int solution(int[][] game_board, int[][] table) {
        answer = 0;
        N = game_board.length;
        
        holes = extract(game_board, 0);
        pieces = extract(table, 1);
        
        boolean[] used = new boolean[pieces.size()];
        
        for (List<int[]> hole : holes) {

            for (int i = 0; i < pieces.size(); i++) {

                if (used[i]) continue;

                List<int[]> piece = pieces.get(i);

                if (hole.size() != piece.size()) continue;

                List<int[]> rotated = piece;

                boolean matched = false;

                for (int r = 0; r < 4; r++) {

                    if (isSame(hole, rotated)) {
                        matched = true;
                        break;
                    }

                    rotated = rotate(rotated);
                }

                if (matched) {
                    used[i] = true;
                    answer += hole.size();
                    break;
                }
            }
        }

        return answer;
    }
    
    // BFS 돌려서 연결된 영역 뽑아내기 
    List<List<int[]>> extract(int[][] map, int target){
        boolean[][] visited = new boolean[N][N];
        
        List<List<int[]>> result = new ArrayList<>();
        
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(visited[r][c]) continue;
                if(map[r][c] != target) continue;
                
                Queue<int[]> que = new ArrayDeque<>();
                List<int[]> shape = new ArrayList<>();
                
                que.offer(new int[]{r, c});
                visited[r][c] = true;
                
                while(!que.isEmpty()){
                    int[] now = que.poll();
                    shape.add(now);
                    
                    for(int i=0; i<4; i++){
                        int nowR = now[0] + dr[i];
                        int nowC = now[1] + dc[i];
                        
                        if(nowR < 0) continue;
                        if(nowC < 0) continue;
                        if(nowR >= N) continue;
                        if(nowC >= N) continue;
                        
                        if(visited[nowR][nowC]) continue;
                        if(map[nowR][nowC] != target) continue;
                        
                        visited[nowR][nowC] = true;
                        que.offer(new int[]{nowR, nowC});
                    }
                }
                
                normalize(shape);
                result.add(shape);
            }
        }
        
        return result;
    }
    
    // 정규화 + 정렬 (R과 C에서 각각 가장 작은 값을 빼준다!)
    // 이러면 위치와 관계 없이 같은 모양이면 모두 (0, 0) 기준으로 정규화
    void normalize(List<int[]> shape){
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        
        for(int[] now : shape){
            minR = Math.min(minR, now[0]);
            minC = Math.min(minC, now[1]);
        }
        
        for(int[] now : shape){
            now[0] -= minR;
            now[1] -= minC;
        }
        
        // 같은건지 비교하려면 순서가 같아야 하므로 정렬까지 해준다!!
        shape.sort((a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
    }
    
    // 시계방향으로 90도 회전
    List<int[]> rotate(List<int[]> shape){
        List<int[]> result = new ArrayList<>();
        
        for(int[] now : shape) result.add(new int[]{-now[1], now[0]});
        
        normalize(result);
        return result;
    }
    
    // 두 도형의 좌표가 모두 같은지 확인
    boolean isSame(List<int[]> a, List<int[]> b){
        if(a.size() != b.size()) return false;
        
        for(int i=0; i<a.size(); i++){
            if(a.get(i)[0] != b.get(i)[0]) return false;
            if(a.get(i)[1] != b.get(i)[1]) return false;
        }
        
        return true;
    }
}