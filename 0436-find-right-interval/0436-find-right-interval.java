class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ans = new int[n];

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals[i][0];      // start
            arr[i][1] = i;                    // idx
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            int si = 0;
            int ei = n-1;
            while (si <= ei) {
                int mid = si + (ei-si)/2;
                if (arr[mid][0] >= intervals[i][1])
                    ei = mid - 1;
                else
                    si = mid + 1;
            }
            ans[i] = (si == n) ? -1 : arr[si][1];
        }

        return ans;
    }
}