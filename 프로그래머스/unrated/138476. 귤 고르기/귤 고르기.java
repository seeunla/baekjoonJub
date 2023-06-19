import java.util.*;
import java.lang.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] arr = new int[10000001];
        int min = 10000001;
        for (int i=0; i<tangerine.length; i++) {
            arr[tangerine[i]-1]++;
            min = Math.min(arr[tangerine[i]-1], min);
        }
        int tol =0;
        Arrays.sort(arr);
        for (int i=arr.length-1; i>=0; i--) {
            if (arr[i] == 0) continue;
            else if (k <= tol) break;
            else {
            tol += arr[i];
            answer++;
            }
        }
        //System.out.println(Arrays.toString(arr) + " " + min);
        
        return answer;
    }
}