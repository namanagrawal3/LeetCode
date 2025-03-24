class Solution {
    public int countDays(int days, int[][] meetings) {
        int n = meetings.length;
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int cnt = 0;
        int start = 1, prevEnd = 0;

        for (int i = 0; i < n; i++) {
            start = meetings[i][0];
            if (start > prevEnd)
                cnt += start - prevEnd - 1;

            prevEnd = Math.max(prevEnd, meetings[i][1]);
        }

        cnt += days - prevEnd;
        return cnt;
    }
}