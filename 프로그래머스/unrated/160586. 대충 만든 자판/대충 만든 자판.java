import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (String key : keymap) {
            for (int i =0; i<key.length(); i++) {
                char s = key.charAt(i);
                
                int move = map.getOrDefault(s, i+1);
                map.put(s, Math.min(move, i+1));
            }
        }
        
        for (int i=0; i<targets.length; i++) {
            for (int j=0; j<targets[i].length(); j++) {
                char t = targets[i].charAt(j);
                
                if (map.containsKey(t)) {
                    answer[i] += map.get(t);
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}