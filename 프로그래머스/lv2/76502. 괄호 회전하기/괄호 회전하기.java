import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        //System.out.println(q);
        for (int i =0; i<s.length(); i++) {
            //System.out.println("s : "+s);
            if (isRight(s)) {
                answer++;
                //System.out.println(answer);
            }
            s += s.charAt(0);
            s = s.substring(1);
        }
        return answer;
    }
    
    public boolean isRight(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i =0; i<s.length(); i++) {
            char x = s.charAt(i);
            //System.out.println(stack);
            // if (x == ']') {
            //     if (stack.peek() == '[') {
            //         stack.pop();
            //         break;
            //     }
            // }
            // else if (x == '}') {
            //     if (stack.peek() == '{') {
            //         stack.pop();
            //         break;
            //     }
            // }
            // else if (x == ')') {
            //     if (stack.peek() == '(') {
            //         stack.pop();
            //         break;
            //     }
            // } 
            
            switch(s.charAt(i)) {
                //닫힌것은 비교하여 뺀다
                case ')':
                    if(stack.isEmpty()) stack.push(s.charAt(i));
                    if(stack.peek() == '(') stack.pop();
                    break;
                case '}':
                    if(stack.isEmpty()) stack.push(s.charAt(i));
                    if(stack.peek() == '{') stack.pop();
                    break;
                case ']':
                    if(stack.isEmpty()) stack.push(s.charAt(i));
                    if(stack.peek() == '[') stack.pop();
                    break;
                //열린것은 담고
                default :
                    stack.push(s.charAt(i));
                    break;
            }
        }
        return stack.isEmpty();
    }
}