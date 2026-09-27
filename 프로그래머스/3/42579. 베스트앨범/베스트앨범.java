import java.util.*;

class Solution {
    
    class Song{
        int id;
        int count;
        
        Song(int id, int count){
            this.id = id;
            this.count = count;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> genMap = new HashMap<>();
        Map<String, List<Song>> songMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            genMap.put(genres[i], genMap.getOrDefault(genres[i], 0) + plays[i]);
            
            // 이렇게 하면 따로 쭉 생성및 초기화해줄 필요 없음
            songMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }
        
        // 장르 정렬
        List<String> genList = new ArrayList<>(genMap.keySet());
        
        genList.sort((a, b) -> 
            Integer.compare(genMap.get(b), genMap.get(a))
        );
        
        // 장르별 노래 정렬
        for(String now : genList){
            List<Song> songList = songMap.get(now);
            
            songList.sort((a, b) -> {
                if(a.count == b.count) return Integer.compare(a.id, b.id);
                return Integer.compare(b.count, a.count);
            });
            
            answer.add(songList.get(0).id);
            
            if(songList.size() >= 2) answer.add(songList.get(1).id);
        }
        
//         int[] temp = new int[answer.size()];
        
//         for(int i=0; i<temp.length; i++) temp[i] = answer.get(i);
        
//         return temp;
        
        // strem 쓰면 간단하게 가능!
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}