class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
    // Approach-1 : Using 'Recursion' (each element will have k-choices of buckets)
    // Approach-2 : Try to check the result for each bucket one-by-one 
    //    (Sorting is optional, it reduces the extra function calls)

        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % k != 0)
            return false;
        
        int target = sum / k;
        Arrays.sort(nums);
        boolean[] used = new boolean[n];

        return checkFun(nums, k, target, n-1, target, used);
    }
    public boolean checkFun(int[] nums, int k, int target, int idx, int currSum, boolean[] used) {
        if (k == 0)
            return true;
        if (currSum == 0)
            return checkFun(nums, k-1, target, nums.length-1, target, used);
        
        for (int i = idx; i >= 0; i--) {
            if (used[i] || currSum < nums[i])
                continue;

            used[i] = true;
            boolean ans = checkFun(nums, k, target, i-1, currSum-nums[i], used);
            if (ans)
                return ans;

            used[i] = false;
        }

        return false;   
    }
}