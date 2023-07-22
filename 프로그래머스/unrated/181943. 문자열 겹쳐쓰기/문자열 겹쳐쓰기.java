import java.util.*;

class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        StringBuilder answer = new StringBuilder();
        
        String rlt = my_string.substring(0, s);
        
        answer.append(rlt);
        answer.append(overwrite_string);
        
        if (answer.toString().length() < my_string.length()) {
            for (int i = answer.toString().length(); i < my_string.length(); i++) {
                answer.append(my_string.charAt(i));
            }
        }
        
        return answer.toString();
    }
}