import java.util.*;
import java.util.Arrays;
import java.util.List;

//1. 삼중 for문 -> 런타임 에러
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int y = 0; y < arr1[0].length; y++){
                //System.out.println("arr2: " +arr2[y][j] + " arr1 " + arr1[i][y]);
                //System.out.println(arr2[y][j] * arr1[i][y]);
                answer[i][j] += arr1[i][y] * arr2[y][j];    
                }
            }
        }
        
        return answer;
    }
}


// class Solution {
//     public int[][] solution(int[][] arr1, int[][] arr2) {
//         int[][] answer = new int[arr1.length][arr2.length];
        
//         List<List<Integer>> list1= new ArrayList<>();
//         List<List<Integer>> list2= new ArrayList<>();
        
//         for (int i = 0; i < arr1.length; i++) {
//             List<Integer> list = new ArrayList<>();
//             for (int j = 0; j < arr1[i].length; j++) {
//                 list.add(arr1[i][j]);
//             }
//             list1.add(list);
//         }
        
//         for (int i = 0; i < arr2.length; i++) {
//             List<Integer> list = new ArrayList<>();
//             for (int j = 0; j < arr2[i].length; j++) {
//                 list.add(arr2[i][j]);
//             }
//             list2.add(list);
//         }
        
//         return answer;
//     }
// }