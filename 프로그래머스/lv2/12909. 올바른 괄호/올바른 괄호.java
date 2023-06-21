import java.util.Stack;

class Solution {
//     boolean solution(String s) {
//         boolean answer = true;
        
//         if (s.charAt(0) != '(') answer = false;
//         if (s.charAt(s.length() -1) != ')') answer = false;
        
//         int open = 0;
//         int close = 0;
        
//         for (int i=0; i < s.length(); i++) {
//             if (s.charAt(i) == '(') open++;
//             else if (s.charAt(i) == ')') close++;
//         }
//         if ((open+close) %2 != 0) answer = false;
//         if (open != close) answer =false;
        
//         int start = 0;
//         int end = 0;
//         for (int i=0; i < s.length(); i++) {
//             if (start < end ) answer =false;
//             if (s.charAt(i) == '(') start++;
//             else if (s.charAt(i) == ')') end++;
//         }

//         return answer;
//     }
    boolean solution(String s) {
        boolean answer = true;
        Stack<Integer> st = new Stack<>();
        
        for (int i=0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(1);
            } else if (s.charAt(i) == ')') {
                if (st.isEmpty()) {
                    answer = false;
                    break;
                }
                st.pop();
            }
        }
        
        if (!st.isEmpty()) {
            answer= false;
        }
        
        return answer;
    }
}