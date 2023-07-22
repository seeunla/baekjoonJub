import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        int[] rank = new int[players.length];
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        for (int i=0; i<players.length; i++) {
            map.put(players[i], i);
            map2.put(i, players[i]);
        }
        
        for (int i=0; i<callings.length; i++) {
            String player1 = callings[i];
            int idx = map.get(player1);
            
            String player2 = map2.get(idx-1);
         
            map.put(player1, idx-1);
            map.put(player2, idx);
            
            map2.put(idx, player2);
            map2.put(idx-1, player1);
        }
        // System.out.println(map2);
        
        for (int i =0; i<rank.length; i++) {
            answer[i] = map2.get(i);
        }
        
        return answer;
    }
    

}