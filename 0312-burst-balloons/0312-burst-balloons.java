class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];

        arr[0] = 1;                             // based on 'MCM' pattern 
        for (int i = 0; i < n; i++) {
            arr[i+1] = nums[i];
        }
        arr[n+1] = 1;

        int[][] dp = new int[n+1][n+1];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        
        return costFun(arr, 1, n, dp);
    }
    public int costFun(int[] nums, int i, int j, int[][] dp) {
        if (i > j)
            return 0;
        if (i == j) {
            int temp = nums[i];
            if (i-1 >= 0)
                temp *= nums[i-1];
            if (i+1 < nums.length)
                temp *= nums[i+1];
            return temp;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = 0;
        for (int k = i; k <= j; k++) {   
            // burst the kth balloon after bursting (i,k-1) and (k+1,j) balloons
            int temp = nums[k];

            if (i-1 >= 0)
                temp *= nums[i-1];          
            // as balloon i-1 will become adjacent to k after bursting (i,k-1) balloons
            if (j+1 < nums.length)
                temp *= nums[j+1];

            temp += costFun(nums, i, k-1, dp) + costFun(nums, k+1, j, dp);
            ans = Math.max(ans, temp);
        }

        return dp[i][j] = ans;
    }
}