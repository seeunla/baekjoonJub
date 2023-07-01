class Solution {
    public int[] solution(String s) {
        int count =0;
        int zero =0;
        while (!s.equals("1")) {
            int one =0;
            for (int i=0; i <s.length(); i++) {
                if (s.charAt(i) == '1') {
                one++;
                } else zero++;
            }
            s = Integer.toBinaryString(one);
            count++;
        }

        
        int[] answer = new int[2];
        answer[0] = count;
        answer[1] = zero;
        return answer;
    }
}