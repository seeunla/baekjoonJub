import java.util.*;

class Solution {
//     public int solution(int n, int[][] results) {
//         int answer = 0;
//         List<Integer>[] fight = new List[n+1];
//         for (int i =1; i<=n; i++) {
//             fight[i] = new ArrayList<>();
//         }
//         for (int[] i : results) {
//             fight[i[0]].add(i[1]); 
//         }
//         System.out.println(Arrays.toString(fight));
        
//         boolean[] visited = new boolean[n+1];
//         int[] rel = new int[n+1];
//         Queue<Integer> queue = new LinkedList<>();
//         Queue<Integer> queue2 = new LinkedList<>();
//         queue.add(1);
//         queue2.add(1);
//         visited[1]= true;
//         while(!queue.isEmpty()) {
//             int cur = queue.poll();
//             System.out.println(cur);
//             for (int next: fight[cur]) {
//                  if (visited[next]) continue;
//                 queue.add(next);
//                 visited[next]= true;
//                 rel[next] += 1;
//             }
//         }
        
//         System.out.println(Arrays.toString(rel));
        
//         return answer;
//     }
    public int solution(int n, int[][] results) {
        int dist[][];
        int answer =0;
        dist = new int[n][n];
        
        for (int i=0; i<results.length; i++) {
            dist[results[i][0]-1][results[i][1]-1] = 1;
            // cnt[results[i][1]-1]++;
            // cnt[results[i][0]-1]++;
        }
        
        // 인접 행렬 초기화
        // for (int[] i : dist) {
        //     System.out.println(Arrays.toString(i));
        // }
        
        for (int k=0; k<n; k++) {
            for (int i =0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if(i==j) {
                        continue;
                    }
                    if(dist[i][k] ==1 && dist[k][j] ==1) {
                        dist[i][j] = 1;
                    }
                }
            }
        }
        
        
        // k를 거치는 모든 경로 중 1개라도 연결돼 있는 경로가 있다면 i와 j는 연결
        //  System.out.println("after: ");
        // for (int i=0; i< dist.length; i++) {
        //     System.out.println(Arrays.toString(dist[i]));
        // }
        
        int cnt = 0;
        for(int i =0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i==j) continue;
                if (dist[i][j] == 1 || dist[j][i] == 1) {
                    cnt++;
                }
            }
            if(cnt == n-1) {
                answer++;
            }
            cnt=0;
        }
        // for (int i=0; i<results.length; i++) {
        //     if (results[i][0] == pos
        //        || results[i][1] == pos) answer++;
        // }
    
        return answer;
    }
}