import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
        HashMap<String, int[]> giftsArr = new HashMap<>();
        HashMap<String, Integer> giftsExponent = new HashMap<>();
        for (String gift : gifts) {
            String[] tmp = gift.split(" ");
            HashMap<String, Integer> tmpMap;
            if (map.get(tmp[0]) == null) {
                tmpMap = new HashMap<>();
            } else {
                tmpMap = map.get(tmp[0]);
            }
            tmpMap.put(tmp[1], tmpMap.getOrDefault(tmp[1], 0) + 1);
            map.put(tmp[0], map.getOrDefault(tmp[0], tmpMap));

            giftsArr.putIfAbsent(tmp[0], new int[2]);
            int[] giveArr = giftsArr.get(tmp[0]);
            giveArr[0]++;
            giftsArr.put(tmp[0], giveArr);

            giftsArr.putIfAbsent(tmp[1], new int[2]);
            int[] receiveArr2 = giftsArr.get(tmp[1]);
            receiveArr2[1]++;
            giftsArr.put(tmp[1], receiveArr2);
            giftsExponent.put(tmp[0], 0);
        }

        int max = 0;
        for (int j = 0; j < friends.length; j++) {
            String friend = friends[j];
            for (int i = j + 1; i < friends.length; i++) {
                String friend2 = friends[i];
                if (!friend.equals(friend2)) {
                    HashMap<String, Integer> user1 = map.getOrDefault(friend, new HashMap<>());
                    HashMap<String, Integer> user2 = map.getOrDefault(friends[i], new HashMap<>());

                    int user1Count = user1.getOrDefault(friend2, 0);
                    int user2Count = user2.getOrDefault(friend, 0);

                    int[] tmpArr1 = giftsArr.getOrDefault(friend, new int[2]);
                    int[] tmpArr2 = giftsArr.getOrDefault(friend2, new int[2]);
                    if (user1.containsKey(friend2) || user2.containsKey(friend)) {
                        if (user1Count > user2Count) {
                            giftsExponent.put(friend, giftsExponent.getOrDefault(friend, 0) + 1);
                        }
                        if (user2Count > user1Count) {
                            giftsExponent.put(friend2, giftsExponent.getOrDefault(friend2, 0) + 1);
                        }
                    }
                    if (user1Count == user2Count) {
                        int user1giftsCount = tmpArr1[0] - tmpArr1[1];
                        int user2giftsCount = tmpArr2[0] - tmpArr2[1];
                        if (user1giftsCount > user2giftsCount) {
                            giftsExponent.put(friend, giftsExponent.getOrDefault(friend, 0) + 1);
                        }
                        if (user2giftsCount > user1giftsCount) {
                            giftsExponent.put(friend2, giftsExponent.getOrDefault(friend2, 0) + 1);
                        }
                    }
                }
            }
            max = Math.max(giftsExponent.getOrDefault(friend, 0), max);
        }

        return max;
    }
}