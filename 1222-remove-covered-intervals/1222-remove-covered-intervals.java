class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
    // Similar to 'Non-overlapping Intervals'
        int n = intervals.length;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return b[1] - a[1];
                return a[0] - b[0];
            }
        });

        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        int cnt = 0;

        for (int i = 1; i < n; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart <= prevEnd && currEnd <= prevEnd) {
                cnt++;
            } else {
                prevStart = currStart;
                prevEnd = currEnd;
            }
        }

        return n-cnt;
    }
}