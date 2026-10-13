// 다익스트라
// 1번 마을에서 각 마을로 가는데 걸리는 시간 <= K 인 경우의 수 구하는 문제.

import java.util.*;

class Solution {
    static final int INF = Integer.MAX_VALUE;
    
    static class Node implements Comparable<Node>{
        int to;
        int cost;
        
        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        
        // 오름차숭
        @Override
        public int compareTo(Node o){
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<Node>[] graph = new ArrayList[N+1];
        
        for(int i=0; i<=N; i++) graph[i] = new ArrayList<>();
        
        for(int[] now : road){
            graph[now[0]].add(new Node(now[1], now[2]));
            graph[now[1]].add(new Node(now[0], now[2]));
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dist[1] = 0;
        pq.offer(new Node(1, 0));
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            int nowTo = now.to;
            int nowCost = now.cost;
            
            if(dist[nowTo] < nowCost) continue;
            
            for(Node next : graph[nowTo]){
                int nextCost = nowCost + next.cost;
                
                if(nextCost < dist[next.to]){
                    dist[next.to] = nextCost;
                    
                    pq.offer(new Node(next.to, nextCost));
                }
            }
        }
        
        for(int i=1; i<=N; i++) 
            if(dist[i] <= K) 
                answer++;
        
        return answer;
    }
}