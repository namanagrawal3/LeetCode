class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
    // Clearly the optimal path turns atmost once ie,
    // 'left only' or 'right only' or 'left then right' or 'right then left'

        int n = fruits.length;
        int[] pre = new int[n];
        pre[0] = fruits[0][1];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i-1] + fruits[i][1];
        }

        int ans = 0;
        for (int d = 0; d <= k/2; d++) {
            // d = 0 will cover the both 'only left' & 'only right' path

            // moving left then right
            int left = startPos - d;
            int right = startPos + (k-2*d);
            int l = lowerBound(fruits, n, left);
            int r = upperBound(fruits, n, right);
            int fruitCovered = (r >= 0) ? pre[r] - (l > 0 ? pre[l-1] : 0) : 0;
            ans = Math.max(ans, fruitCovered);

            // moving right then left
            right = startPos + d;
            left = startPos - (k-2*d);
            l = lowerBound(fruits, n, left);
            r = upperBound(fruits, n, right);
            fruitCovered = (r >= 0) ? pre[r] - (l > 0 ? pre[l-1] : 0) : 0;
            ans = Math.max(ans, fruitCovered);
        }

        return ans;
    }
    public int lowerBound(int[][] fruits, int n, int target) {
        int si = 0;
        int ei = n-1;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (fruits[mid][0] >= target)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        return si;
    }
    public int upperBound(int[][] fruits, int n, int target) {
        int si = 0;
        int ei = n-1;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (fruits[mid][0] <= target)
                si = mid + 1;
            else
                ei = mid - 1;
        }
        return ei;   
    }
}