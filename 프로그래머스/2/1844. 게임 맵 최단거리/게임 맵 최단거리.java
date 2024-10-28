import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] dx = {0, 1, 0, -1};
    public int[] dy = {1, 0, -1, 0};
    public int[][] map;
    public int answer;
    public boolean[][] visited;
    
    public int solution(int[][] maps) {
        this.map = maps;
        this.answer = 0;
        int N = maps.length;
        int M = maps[0].length;
        this.visited = new boolean[N][M];
        bfs(0,0);
        if (map[N-1][M-1] >= maps.length) {
            return map[N-1][M-1];
        }
        return -1;
    }
    
    public void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
        visited[i][j] = true;
        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            for (int k=0; k<4; k++) {
                
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                
                if (x >=0 && y >= 0 && x < map.length && y < map[0].length) {
                    if(map[x][y] !=0 && visited[x][y] == false) {
                        visited[x][y] = true;
                        map[x][y] = map[now[0]][now[1]] + 1;
                        queue.add(new int[] {x,y});
                    } 
                } else answer = -1;
            }
            
        }
    }
}