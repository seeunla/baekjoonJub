import java.util.*;
class Solution {
    // public int[] solution(int[] numbers) {
    //     int[] answer = new int[numbers.length];
    //     answer[numbers.length-1] = -1;
    //     for (int i =0; i<numbers.length; i++) {
    //         for (int j=i+1; j<numbers.length; j++) {
    //             if (numbers[i] <numbers[j]) {
    //                 answer[i] = numbers[j];
    //                 break;
    //             } 
    //             else {
    //                 answer[i] = -1;
    //             }
    //         }
    //     }
    //     return answer;
    // }
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Stack<Integer> st = new Stack<>();
        for (int i =0; i<numbers.length; i++) {
            //System.out.println(st);
            while(!st.isEmpty() && numbers[i] > numbers[st.peek()]) {
                int idx = st.pop();
                answer[idx] = numbers[i];
                //System.out.println(idx);
            }
            st.push(i);
        }
        return answer;
    }
}