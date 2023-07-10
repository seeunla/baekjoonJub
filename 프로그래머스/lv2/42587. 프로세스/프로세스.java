import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Queue;


class Solution {
    private Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    private int answer = 0;
    
    public int solution(int[] priorities, int location) {
        for (int i : priorities) {
            queue.add(i);
        }
        

        while (!queue.isEmpty()) {
            for (int i =0; i< priorities.length; i++) {
                if (queue.peek() == priorities[i]) {
                    queue.poll();
                    answer++;
                    if (location == i) {
                        return answer;
                    }
                    
                }
            }
        }
        
        return answer;
    }
}