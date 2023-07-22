import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> pocketmons = new HashSet<>();
        for (int i: nums) {
            pocketmons.add(i);
        }
        
        // System.out.println(pocketmons);
        return Math.min(pocketmons.size(), nums.length/2);
    }
}