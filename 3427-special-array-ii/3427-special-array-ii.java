class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;

        int[] badIdx = new int[n];
        int[] pre = new int[n];
        boolean[] ans = new boolean[queries.length];

        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == nums[i-1] % 2)
                badIdx[i] = 1;                          // 'i' is bad with 'i-1'
        }
        
        pre[0] = badIdx[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i-1] + badIdx[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            if (pre[right] - pre[left] == 0)
                ans[i] = true; 
        }

        return ans;
    }
}