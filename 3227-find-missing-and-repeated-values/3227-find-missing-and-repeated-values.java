class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int xor = 0;                            // same as "Single Number III"

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                xor ^= grid[i][j];
            }
        }
        for (int i = 1; i <= n*n; i++) {
            xor ^= i;
        }

        int mask = xor & (-xor);
        int groupA = 0;
        int groupB = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((mask & grid[i][j]) == 0)
                    groupA ^= grid[i][j];
                else
                    groupB ^= grid[i][j];
            }
        }
        for (int i = 1; i <= n*n; i++) {
            if ((mask & i) == 0)
                groupA ^= i;
            else
                groupB ^= i;
        }

        int ca = 0, cb = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == groupA)
                    ca++;
                else if (grid[i][j] == groupB)
                    cb++;
            }
        }

        int a = (ca == 2) ? groupA : groupB;
        int b = (cb == 0) ? groupB : groupA;
        return new int[] {a, b};
    }
}