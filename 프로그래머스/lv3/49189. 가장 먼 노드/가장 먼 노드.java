import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] visited = new boolean[n+1];
        List<Integer>[] nums = new List[n+1];
        
        for(int i =1; i<=n; i++) {
            nums[i] = new ArrayList<>();
        }
        
        for(int[] line : edge) {
            nums[line[0]].add(line[1]);
            nums[line[1]].add(line[0]);
        }
        
        int[] dist = new int[n+1];
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(1);
        visited[1] = true;
        
        while (!q.isEmpty()) {
            //System.out.println(q);
            int cur = q.poll();
            for(int next: nums[cur]) {
                if (visited[next]) {
                    continue;
                }
                q.add(next);
                visited[next] = true;
                dist[next] = dist[cur] +1;
                
                //System.out.println( cur+" "+next+" "+dist[cur]+" "+dist[next]);
            }
        }
        
        int max = 0;
        for(int i =1; i<=n; i++) {
            max = Math.max(max, dist[i]);
        }
        
        for( int i =1; i<=n; i++) {
            if (dist[i] == max) answer++;
        }
        return answer;
    }
}