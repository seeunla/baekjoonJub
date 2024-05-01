import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> cards = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            cards.add(i);
        }
        int idx = 1;
        while(cards.size() != 1) {
            if (idx % 2 != 0) {
                cards.poll();
            }
            else  {
                int tmp = cards.poll();
                cards.add(tmp);
            }
            idx++;
        }

        System.out.println(cards.peek());
    }
}
