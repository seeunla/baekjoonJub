class Solution {
    public int solution(int n) {
        String binary = Integer.toBinaryString(n);
        int n1 =0;
        for (int i=0; i< binary.length() ; i++) {
            if (binary.charAt(i) == '1') {
                n1++;
            } 
        }
        int answer = 0;
        int index =1;
        
        while(true) {
            int num = n+index;
            String binary2 = Integer.toBinaryString(num);
            int n2 =0;
            for (int i=0; i<binary2.length(); i++) {  
              if (binary2.charAt(i) == '1') n2++;
            }
            if (n1 == n2) {
                answer =num;
                break;
            }
            index++;
        }
      
        
        return answer;
    }
}