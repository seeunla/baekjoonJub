import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (long i : works) {
            pq.add(i);
        }

        while (n > 0) {
            long currWork = pq.poll();
            if (currWork > 0) {
                currWork = currWork - 1;
            }
            pq.add(currWork);
            n--;
        }

        for (Long aLong : pq) {
            answer += (long) Math.pow(aLong, 2);
        }

        if (answer >= 0) return answer;

        return 0;
    }
}