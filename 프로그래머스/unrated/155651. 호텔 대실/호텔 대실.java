import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] time = new int[book_time.length][2];
        for (int i =0; i< book_time.length; i++) {
            String s = book_time[i][0].replaceAll("[:]", "");
            String s2 = book_time[i][1].replaceAll("[:]", "");
            int a = Integer.parseInt(s);
            int b = Integer.parseInt(s2);
            // System.out.println(s);
            b += 10;
            if (b % 100 >= 60) {
                b += 40;
            }
            time[i][0] = a;
            time[i][1] = b;
        }
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] S, int[] E) {
                if (S[0] == E[0]) {
                    return S[1] - E[1];
                }
                return S[0] - E[0];
            }
        });
        
        // for (int i =0; i<book_time.length; i++) {
        //     System.out.println(time[i][0] + " " + time[i][1]);
        // }
        
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        
        for (int[] timeArr : time) {
            // System.out.println(rooms);
            if ( rooms.size() == 0) {
                rooms.add(timeArr[1]);
                continue;
            }
            
            if (timeArr[0] >= rooms.peek()) {
                rooms.poll();
                rooms.add(timeArr[1]);
            } else {
                rooms.add(timeArr[1]);
            }
            // System.out.println(rooms);
        }
        return rooms.size();
    }
}