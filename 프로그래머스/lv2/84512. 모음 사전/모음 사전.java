import java.util.Arrays;

class Solution {
    private String[] alphabet = {"A", "E", "I", "O", "U"};
    private boolean go = true;
    private int answer = 0;
    public int solution(String word) {
        
        String[] words = word.split("");
        String[] result = new String[words.length];
        dfs(0, words, result);
        
        return answer;
    }
    
    public void dfs(int depth, String[] words, String[] result) {
        if (depth >= 5) {
            return;
        }
        for (int i =0 ; i<5; i++) {
            if (depth < words.length) {
                result[depth] = alphabet[i];
            }
            answer++;
            if(depth >= words.length -1 && Arrays.equals(result, words)) {
                go = false;
                break;
            }
            dfs(depth+1, words, result);
            if (!go) {
                return;
            }
        }
    }
}