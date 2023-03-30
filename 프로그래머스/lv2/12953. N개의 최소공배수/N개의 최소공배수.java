class Solution {
    public int solution(int[] arr) {
        int next =1;
        for (int i=0; i<arr.length; i++) {
            int a = getGcd(next, arr[i]);
            next = next * arr[i] / a;
            // System.out.println(next);
        }
        
        return next;
    }
    
    public int getGcd(int a, int b) {
        if (b==0) return a;
        return getGcd(b, a%b);
    }
}