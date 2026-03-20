class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
    // Use the Bruteforce Approach and insert every element for a matrix in the TreeSet
     
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m-k+1][n-k+1];

        for (int i = 0; i <= m-k; i++) {
            for (int j = 0; j <= n-k; j++) {
                
                TreeSet<Integer> set = new TreeSet<>();
                for (int p = 0; p < k; p++) {
                    for (int q = 0; q < k; q++) {
                        set.add(grid[i+p][j+q]);
                    }
                }

                if (set.size() == 1) {
                    ans[i][j] = 0;
                    continue;
                }

                List<Integer> l = new ArrayList<>(set);
                int minDiff = Integer.MAX_VALUE;
                for (int idx = 0; idx < l.size()-1; idx++) {
                    int diff = l.get(idx+1) - l.get(idx);
                    minDiff = Math.min(minDiff, diff);
                }
                ans[i][j] = minDiff;
            }
        }

        return ans;
    }
}