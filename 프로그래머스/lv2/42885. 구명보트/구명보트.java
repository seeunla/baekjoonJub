import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int min =0;
        int count =0;

        for (int max=people.length -1; min<= max; max--) {
            if (people[min] + people[max] <= limit) min++;
                count++;
            
            // System.out.println("min : " +min);
            //System.out.println("max : " +max);
            // System.out.println("count: " + count);
        }
        
        return count; 
    }
}