import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int time = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            list.add(time);
        }

        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        int tmp = 0;
        for (int i = 0; i < list.size(); i++) {
            if (stack.isEmpty()) {
                int value = list.get(i);
                stack.push(value);
                tmp = value;
                continue;
            }
            if (stack.size() == 1) tmp = stack.peek();
            if (tmp >= list.get(i)) {
                stack.push(list.get(i));
            } else {
                result.add(stack.size());
                stack.removeAllElements();
                stack.push(list.get(i));
            }
        }

        if (!stack.isEmpty()) {
            result.add(stack.size());
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}