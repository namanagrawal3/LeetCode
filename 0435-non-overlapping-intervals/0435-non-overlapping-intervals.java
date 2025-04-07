class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        int cnt = 0;

        for (int i = 1; i < n; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart < prevEnd) {  // overlapping interval
                cnt++;
                if (currEnd < prevEnd) {// we will remove interval with longer length
                    prevStart = currStart;
                    prevEnd = currEnd;
                }
            }
            else {
                prevStart = currStart;
                prevEnd = currEnd;
            }
        }

        return cnt;
    }
}