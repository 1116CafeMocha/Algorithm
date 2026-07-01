import java.util.*;

class Solution {
    static Map<String, List<Ticket>> graph;
    static boolean[] visited;
    static String[] answer;
    
    static class Ticket {
        String to;
        int index;
        
        Ticket(String to, int index){
            this.to = to;
            this.index = index;
        }
    }
    
    public String[] solution(String[][] tickets) {
        graph = new HashMap<>();
        visited = new boolean[tickets.length];
        
        for(int i=0; i<tickets.length; i++){
            String from = tickets[i][0];
            String to = tickets[i][1];
            
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new Ticket(to, i));
        }
        
        for(String now : graph.keySet()){
            graph.get(now).sort((a, b) -> a.to.compareTo(b.to));
        }
        
        List<String> route = new ArrayList<>();
        route.add("ICN");
        
        dfs("ICN", tickets.length, 0, route);
        
        return answer;
    }
    
    boolean dfs(String current, int ticketCount, int usedCount, List<String> route){
        if(usedCount == ticketCount){
            answer = route.toArray(new String[0]);
            return true;
        }
        
        List<Ticket> nextTickets = graph.get(current);
        
        if(nextTickets == null) return false;
        
        for(Ticket ticket : nextTickets){
            if(!visited[ticket.index]){
                visited[ticket.index] = true;
                route.add(ticket.to);
                
                if(dfs(ticket.to, ticketCount, usedCount+1, route)) return true;
                
                route.remove(route.size() -1);
                visited[ticket.index] = false;
            }
        }
        
        return false;
    }
}