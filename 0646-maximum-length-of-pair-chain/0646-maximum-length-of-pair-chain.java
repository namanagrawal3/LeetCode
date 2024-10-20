class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        int n = pairs.length; 
        int[][] dp = new int[n][n];

        return lisFun(pairs, n, 0, -1, dp);
    }
    public int lisFun(int[][] pairs, int n, int currIdx, int prevIdx, int[][] dp) {
        if (currIdx == n)
            return 0;

        if (dp[currIdx][prevIdx+1] != 0)
            return dp[currIdx][prevIdx+1];

        int take = 0;
        if (prevIdx == -1 || pairs[prevIdx][1] < pairs[currIdx][0])
            take = 1 + lisFun(pairs, n, currIdx + 1, currIdx, dp);

        int not_take = lisFun(pairs, n, currIdx + 1, prevIdx, dp);

        return dp[currIdx][prevIdx+1] = Math.max(take, not_take);
    }
}