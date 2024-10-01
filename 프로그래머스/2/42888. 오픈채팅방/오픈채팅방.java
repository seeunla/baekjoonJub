import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String[] solution(String[] record) {
        String[] uid = new String[record.length];
        String[] nickName = new String[record.length];

        HashMap<String, Integer> uidMap = new HashMap<>();
        HashMap<String, String> nickNameMap = new HashMap<>();

        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String[] tmp = record[i].split(" ");

            uid[i] = tmp[1];
            uidMap.put(tmp[1], uidMap.getOrDefault(tmp[1], i));

            if (tmp.length == 2) {
                nickName[i] = tmp[1];
                list.add(new String[]{tmp[0], uid[i]});
            }
            if (tmp.length == 3) {
                nickName[i] = tmp[2];
                nickNameMap.put(uid[i], nickName[i]);
                list.add(new String[]{tmp[0], uid[i], nickName[i]});
            }
        }

        List<String[]> result = new ArrayList<>();
        for (String[] strings : list) {
            String tmpUid = strings[1];
            if (nickNameMap.containsKey(tmpUid) && strings.length == 3) {
                strings[2] = nickNameMap.get(tmpUid);
            }

            if (nickNameMap.containsKey(tmpUid) && strings.length == 2) {
                strings[1] = nickNameMap.get(tmpUid);
            }

            if (strings[0].equals("Enter")) {
                strings = new String[]{String.format("%s님이 들어왔습니다.", strings[2])};
                result.add(strings);
            }
            if (strings[0].equals("Leave")) {
                strings = new String[]{String.format("%s님이 나갔습니다.", strings[1])};
                result.add(strings);
            }
        }

        String[] answer = new String[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i)[0];
        }
        
        return answer;
    }
}