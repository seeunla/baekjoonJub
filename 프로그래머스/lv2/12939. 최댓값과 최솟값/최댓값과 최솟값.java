class Solution {
    public String solution(String s) {
        String answer = "";
        String[] array = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i =0; i < array.length; i++) {
            int number = Integer.parseInt(array[i]);
            
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        
        answer = min + " " + max;
        
        return answer;
    }
}