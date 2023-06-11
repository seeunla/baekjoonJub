import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        List<Integer> ansList = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    int sum = bfs(maps, visited, i, j);
                    ansList.add(sum);
                }
            }
        }
        
        if (ansList.isEmpty()) {
            return new int[]{-1};
        } else {
            int[] ans = new int[ansList.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = ansList.get(i);
            }
            Arrays.sort(ans);
            return ans;
        }
    }
    
    public int bfs(String[] maps, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int sum = 0;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            sum += maps[curX].charAt(curY) - '0';
            
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length()) {
                    continue;
                }
                if (maps[nextX].charAt(nextY) == 'X' || visited[nextX][nextY]) {
                    continue;
                }
                queue.offer(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
            }
        }
        return sum;
    }
}
