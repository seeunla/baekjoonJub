import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
//     public int solution(String str1, String str2) {
//         str1 = str1.toLowerCase();
//         str2 = str2.toLowerCase();

//         List<String> list1 = new ArrayList<>();
//         List<String> list2 = new ArrayList<>();

//         int parent = (str1.length() - 1) + (str2.length() - 1);
//         int child = 0;

//         for (int i = 0; i < str1.length() - 1; i++) {
//             char ch1 = str1.charAt(i);
//             char ch2 = str1.charAt(i + 1);
//             if (!isAlphabet(str1.charAt(i))) {
//                 parent--;
//                 continue;
//             }
//             if (!isAlphabet(str1.charAt(i + 1))) {
//                 parent--;
//                 continue;
//             }

//             list1.add(ch1 + String.valueOf(ch2));
//         }


//         for (int i = 0; i < str2.length() - 1; i++) {
//             char ch1 = str2.charAt(i);
//             char ch2 = str2.charAt(i + 1);
//             if (!isAlphabet(str2.charAt(i))) {
//                 parent--;
//                 continue;
//             }
//             if (!isAlphabet(str2.charAt(i + 1))) {
//                 parent--;
//                 continue;
//             }

//             list2.add(ch1 + String.valueOf(ch2));
//         }

//         for (int i = 0; i < list1.size(); i++) {
//             for (int j = 0; j < list2.size(); j++) {
//                 if (list1.get(i).equals(list2.get(j))) {
//                     child++;
//                     parent--;
//                     break;
//                 }
//             }
//         }

//         double answer = (double) child / parent * 65536;
//         if (child == 0 && parent == 0) return 65536;
//         return (int) Math.floor(answer);
//     }
    
    public int solution(String str1, String str2) {
        /*
        1. 소문자 변환
        2. 비교할 문자열만 추출 
        3. 교집합에 속하는 문자열 각각 찾기
        4. 두 개의 Map에서 교집합 구하기 (둘 중에 더 작은 값)
        5. 합집합은 전체 - 교집합
        */
    
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i + 1);
            if (isAlphabet(str1.charAt(i)) && isAlphabet(str1.charAt(i + 1))) {
                list1.add(ch1 + String.valueOf(ch2));
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i + 1);
            if (isAlphabet(str2.charAt(i)) && isAlphabet(str2.charAt(i + 1))) {
                list2.add(ch1 + String.valueOf(ch2));
            }
        }


        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : list1) {
            for (String string : list2) {
                if (s.equals(string)) {
                    map1.put(s, map1.getOrDefault(s, 0) + 1);
                    break;
                }
            }
        }

        for (String s : list2) {
            for (String string : list1) {
                if (s.equals(string)) {
                    map2.put(s, map2.getOrDefault(s, 0) + 1);
                    break;
                }
            }
        }

        int intersection = 0;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            intersection += Math.min(map2.get(entry.getKey()), entry.getValue());
        }

        int union = list1.size() + list2.size() - intersection;

        if (intersection == union) return 65536;
        
        double answer = (double) intersection / union * 65536;
        return (int) Math.floor(answer);
    }
    
    boolean isAlphabet(char str) {
        return (str >= 'a' && str <= 'z') || (str >= 'A' && str <= 'Z');
    }
}