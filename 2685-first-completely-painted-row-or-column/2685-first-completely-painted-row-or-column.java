class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < m*n; i++) {
            map.put(arr[i], i);
        }

        int minIdx = Integer.MAX_VALUE;
    
        for (int row = 0; row < m; row++) {     // checking the last index for each row
            int max = -1;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, map.get(mat[row][j]));
            }

            minIdx = Math.min(minIdx, max);
        }

        for (int col = 0; col < n; col++) {     // checking the last index for each col
            int max = -1;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, map.get(mat[i][col]));
            }

            minIdx = Math.min(minIdx, max);
        }

        return minIdx;
    }
}