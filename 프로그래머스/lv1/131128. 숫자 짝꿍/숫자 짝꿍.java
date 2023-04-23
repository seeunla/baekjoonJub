import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] cntX = new int[10];
        int[] cntY = new int[10];
        
        for (String tmpX : X.split("")) cntX[Integer.parseInt(tmpX)]++;
        for (String tmpY : Y.split("")) cntY[Integer.parseInt(tmpY)]++;
        
        
        for (int i = 9; i >= 0; i--){
            while(cntX[i] > 0 && cntY[i] > 0){
                sb.append(i);
                cntX[i]--;
                cntY[i]--;
            }
        }
        
        if (sb.toString().length() == 0) {
            sb.append("-1");
        } else if (sb.toString().charAt(0) - '0' == 0) {
            sb = new StringBuilder();
            sb.append("0");
        }

        return sb.toString();
    }
}