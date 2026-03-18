class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        // "Difference Array" Technique for 2-D array (assume it for 1-D array)
        // (treat the each col as a single element, thus becomes 1-D array)

        int[][] diff = new int[n][n];

        for (int[] q: queries) {
            int r1 = q[0], c1 = q[1];
            int r2 = q[2], c2 = q[3];

            for (int i = r1; i <= r2; i++) {
                diff[i][c1] += 1;
                if (c2 + 1 < n)
                    diff[i][c2+1] -= 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                diff[i][j] += diff[i][j-1];
            }
        }

        return diff;
    }
}