import java.util.*;
import java.lang.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] arr = new int[10000000];
        int min = 10000001;
        for (int i=0; i<tangerine.length; i++) {
            arr[tangerine[i]-1]++;
            min = Math.min(arr[tangerine[i]-1], min);
        }
        int tol =0;
        for (int i: arr) {
            if (i <= min) continue;
            else if (k <= tol) break;
            else {
            tol += i;
            answer++;
            }
        }
        // System.out.println(Arrays.toString(arr) + " " + min);
        
        return answer;
    }
}