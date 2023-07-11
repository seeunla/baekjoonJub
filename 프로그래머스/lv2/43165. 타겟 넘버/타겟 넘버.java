import java.util.*;

// class Solution {
//     private int answer = 0;
//     private int sum =0;
//     private ArrayList<Integer> A;
//     private boolean[] visited;
    
//     public int solution(int[] numbers, int target) {
        
//         visited = new boolean[numbers.length];
//         A = new ArrayList<>();
        
//         for (int i=0; i<numbers.length; i++) {
//             A.add(numbers[i]);
//         }
        
//         for(int i=0; i<numbers.length; i++) {
//             dfs(i, 1);
//             if(sum == target) {
//                 answer++;
//                 sum = 0;
//             }
//         }
        
//         return answer;
//     }
    
//     public void dfs(int now, int depth) {
//         if (depth == 5) {
//             return;
//         }

//         visited[now] = true;
        
//         for (int i : A) {
//             System.out.println("sum : "+ sum);
//             if (!visited[i]) {
//                 sum += -i;
//                 dfs(i, depth+1);
//             }
//         }
//         visited[now] = false;
//     } 
// }

class Solution {
    private int answer;
    private int[] numbers;
    private int target;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        this.answer =0;
        
        dfs(0,0);
        
        return answer;
    }
    
    public void dfs(int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        dfs(depth+1, sum + numbers[depth] );
        dfs(depth+1, sum - numbers[depth]);
    }
}

// 1. 정수를 음수로 바꾸고 나머지 인덱스값을 더해야한다.