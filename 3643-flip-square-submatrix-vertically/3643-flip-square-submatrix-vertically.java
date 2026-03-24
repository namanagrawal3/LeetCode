class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
    // Simply using 2 pointers, swap the two rows' elements
        int top = x;
        int bottom = x+k - 1;

        while (top < bottom) {
            for (int j = y; j < y+k; j++) {
                int temp = grid[top][j];
                grid[top][j] = grid[bottom][j];
                grid[bottom][j] = temp;
            }
            top++;
            bottom--;
        }

        return grid;
    }
}