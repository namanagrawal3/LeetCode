class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        // Simply use the Prefix - Suffix Concept ('Product except itself')
        int n = grid.length;
        int m = grid[0].length;
        int mod = 12345;

        int[][] suff = new int[n][m];
        long suffProd = 1L;
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                suff[i][j] = (int) suffProd;
                suffProd *= grid[i][j];
                suffProd %= mod; 
            }
        }

        long prefProd = 1L;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                suff[i][j] = (int) (prefProd * suff[i][j]) % mod;
                prefProd *= grid[i][j]; 
                prefProd %= mod; 
            }
        }

        return suff;
    }
}