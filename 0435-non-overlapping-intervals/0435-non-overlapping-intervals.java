class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int start = intervals[0][0];
        int end = intervals[0][1];
        int cnt = 1;

        for(int i = 1; i < n; i++) {
            int newStart = intervals[i][0];
            int newEnd = intervals[i][1];

            if(newStart >= end) {
                cnt += 1;
                start = newStart;
                end = newEnd;
            }
        }

        return n - cnt;
        
    }
}