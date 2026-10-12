class Solution {
    public String solution(String s) {
        String[] words = s.split(" ", -1);
        
        for(int w=0; w < words.length; w++){
            char[] temp = words[w].toCharArray();
            for(int i=0; i<temp.length; i+=2) temp[i] = Character.toUpperCase(temp[i]);
            for(int i=1; i<temp.length; i+=2) temp[i] = Character.toLowerCase(temp[i]);
            words[w] = String.valueOf(temp);
        }
        
        return String.join(" ", words);
    }
}