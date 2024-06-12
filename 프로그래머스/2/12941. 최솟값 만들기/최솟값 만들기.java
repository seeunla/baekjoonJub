import java.util.Comparator;
import java.util.PriorityQueue;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

            PriorityQueue<Integer> queue1 = new PriorityQueue<>();
            PriorityQueue<Integer> queue2 = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i : A) {
                queue1.add(i);
            }
            for (int i : B) {
                queue2.add(i);
            }

            while (!queue2.isEmpty()) {
                answer += (queue1.poll() * queue2.poll());
            }

            return answer;
    }
}