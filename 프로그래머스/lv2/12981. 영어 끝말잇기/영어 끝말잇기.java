import java.util.*;

class Solution {
//     public int[] solution(int n, String[] words) {
//         int[] answer = {0,0};
//         int stop = 0;
//         Stack<Character> st = new Stack<>();
//         List<String> l = new ArrayList<>();
        
//         for (int i =0; i<words.length; i++) {
//             char start = words[i].charAt(0);
//             char end = words[i].charAt(words[i].length() -1);
//             // System.out.println(start + " " + end);
//             if (words[i].length() < 2 || words[i].length() >50) {
//                 stop = i;
//                 break;
//             }
//             if (st.isEmpty()) {
//                 st.push(end);
//                 l.add(words[i]);
//             } else {
//                 char piece = st.peek();
//                 if (start == piece) {
//                     st.pop();
//                     st.push(end);
//                 } 
//                 if (start != piece) {
//                     stop = i+1;
//                     break;
//                 }
//                 if (l.contains(words[i])) {
//                     stop = i+1;
//                     break;
//                 }
//                 l.add(words[i]); 
//             }
//         }

//         if (stop % n != 0) {
//                 answer[0] = stop % n;
//                 answer[1] = stop/n + stop % n;
//         } else if (stop -1 == words.length) {
//             answer[0] = 0;
//             answer[1] = 0;
//         } 
//         else {
//             answer[0] = stop/ n;
//             answer[1] = stop/n ;
//         }
        
//         // System.out.println(stop);

//         return answer;
//     }
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        int stop = 0;
        
        List<String> l = new ArrayList<>();
        
        for (int i =0; i<words.length; i++) {
            if (l.size() == 0) {
                l.add(words[i]);
                continue;
            }
            if (l.contains(words[i])) {
                stop = i;
                break;
            }
            if (words[i].length() < 2 || words[i].length() >50 
               || words[i].length() == 1) {
                stop = i;
                break;
            }
            if (words[i].length() == 1) {
                stop = i;
                break;
            }
            char start = words[i].charAt(0);
            char end = l.get(i-1).charAt(l.get(i-1).length() -1);

            // System.out.println(start + " " + end);

            if (start != end) {
                stop = i;
                break;
            }
            l.add(words[i]);
        }

        // System.out.println(stop);
        if (stop > 0) {
            answer[0] = stop % n +1;
            answer[1] = stop/n + 1;
            return answer;
        } 
        
        // System.out.println(l);

        return answer;
    }
}