class Solution {
    public int largestSubmatrix(int[][] matrix) {
        // Similar to the Largest Rectangle Historam & Maximal Rectangle Area (see the hint)

        int m = matrix.length;
        int n = matrix[0].length;

        int maxArea = 0;
        int[] prevRow = new int[n];

        for (int i = 0; i < m; i++) {
            int[] currRow = matrix[i].clone();          // .clone() --> deep copy

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && i > 0)
                    currRow[j] += prevRow[j];
            }

            int[] heights = currRow.clone();
            Arrays.sort(heights);

            for (int j = 0; j < n; j++) {
                int base = n-j;
                int height = heights[j];

                maxArea = Math.max(maxArea, base * height);
            }

            prevRow = currRow;
        }

        return maxArea;
    }
}