class Solution {
    public int[] productQueries(int n, int[][] queries) {
    // Binary representation of n will be the minimum sum of powers of 2
        List<Integer> pow = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0)
                pow.add(1 << i);
        }

        int m = queries.length;
        int[] ans = new int[m];
        long mod = 1000000007;

        for (int i = 0; i < m; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            long pro = 1;
            for (int j = start; j <= end; j++) {
                pro = (pro * pow.get(j)) % mod;
            }
            
            ans[i] = (int) pro;
        }
        
        return ans;
    }
}