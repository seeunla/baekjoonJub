

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        
        StringBuffer str = new StringBuffer();
        str.append(Character.toUpperCase(s.charAt(0)));
        for (int i =1; i<s.length(); i++) {
            if(s.charAt(i) == ' ') str.append(" ");
            else if(s.charAt(i-1) == ' ') {
                str.append(Character.toUpperCase(s.charAt(i)));
            }
            else str.append(s.charAt(i));
        }
        
        return str.toString();
    }
}