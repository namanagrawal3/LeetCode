class Solution {
    public int countSubmatrices(int[][] grid, int k) {
    // Take the prefix sum of both rows & cols
    
        int m = grid.length;
        int n = grid[0].length;

        int cnt = 0;
        int[] prevRow = new int[n];

        for (int i = 0; i < m; i++) {
            int[] currRow = grid[i].clone();
            for (int j = 0; j < n; j++) {
                currRow[j] += prevRow[j];
            }
            
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += currRow[j];
                if (sum <= k)
                    cnt++;
                else
                    break;
            }

            prevRow = currRow;
        }

        return cnt;
    }
}