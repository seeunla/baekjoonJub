import java.util.*;

class Solution {
    
//     public int[] solution(int[] arr, int[] query) {
//         int max = 0;
//         int min = 0;
//         for (int i = 0 ; i < query.length ; i++) {
//             if (i % 2 == 0) {
//                 max = min + query[i];
//             } else {
//                 min = query[i];
//             }
//         }
        
//         int[] answer = new int[max-min+1];
        
//         // System.out.println ( max + " " + min);
//         int idx = 0;
//         for (int i = min; i <= max; i++) {
//             answer[idx] = arr[i];
//             idx++;
//         }
        
//         return answer;
//     }
    
//     public int[] solution(int[] arr, int[] query) {
//         StringBuilder sb = new StringBuilder();
//         for (int i : arr) {
//             sb.append(i);
//         }
        
//         String a = sb.toString();
        
//         for (int i = 0; i < query.length ; i++) {
//             if (i % 2 == 0) {
//                 a = a.substring(0 , query[i]+1);
//             } else {
//                 a = a.substring(query[i]);
//             }
//         }
        
//         // System.out.println(a);
//         int[] answer = new int[a.length()];
//         for (int i = 0 ; i < answer.length; i++) {
//             answer[i] = a.charAt(i) - '0';
//         }
        
//         return answer;
//     }
    
    public int[] solution(int[] arr, int[] query) {
        int[] answer = arr;
        for (int i = 0; i < query.length ; i++) {
            if (i % 2 == 0) {
                answer = Arrays.copyOfRange(answer, 0 , query[i]+1);
            } else {
                answer = Arrays.copyOfRange(answer, query[i], answer.length);
            }
        }
        return answer;
    }
}