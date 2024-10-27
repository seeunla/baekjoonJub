class Solution {
    private int[] diffs1;
    private int[] times1;
    private int answer = 0;
    private long time;
    public int solution(int[] diffs, int[] times, long limit) {
        diffs1 = diffs;
        times1 = times;

        int min = 100_000; // 최소 시간
        int max = 1; // 최대 시간
        int mid = (min + max) / 2;
        long tmp = solvingTime(mid);
        while (max < min) {
            // System.out.println(min + " " + max + " " + mid + " " + tmp);
            tmp = solvingTime(mid);
            if (tmp > limit) {
                max = mid + 1;
            } else {
                min = mid;
            }
            mid = (min + max) / 2;
            answer = max;
        }
        return answer;
    }
    
    private long solvingTime(int level) {
        time = 0;
        for (int i = 0; i < diffs1.length; i++) {
            if (i == 0) {
                time += times1[i];
            }
            else if (diffs1[i] <= level) {
                time += times1[i];
            } else {
                time += (times1[i] + times1[i - 1]) * (diffs1[i] - level) + times1[i];
            }
        }
        return time;
    }
}