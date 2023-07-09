import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();

        // type별로 옷 종류가 몇개인지 세기
        for(int i=0; i<clothes.length; i++){
            String cloth_type = clothes[i][1];
            hash.put(cloth_type, hash.getOrDefault(cloth_type, 1) + 1);
            // System.out.println("hash: " + hash);
        }

        for (String key : hash.keySet()) {
            answer *= hash.get(key);
            // System.out.println("answer: " + answer);
        }

        return answer-1;
    }
}