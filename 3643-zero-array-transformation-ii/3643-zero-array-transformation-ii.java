class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
    // For range-updation queries, we will use 'Difference Array' technique

        if (allZero(nums))
            return 0;

        int si = 0;
        int ei = queries.length-1;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (isPossible(mid, nums, queries))
                ei = mid - 1;
            else
                si = mid + 1;
        }

        return (si == queries.length) ? -1 : si+1;
    }
    public boolean isPossible(int idx, int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n];              // creating the difference array
        diff[0] = nums[0];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i-1];
        }

        for (int i = 0; i <= idx; i++) {
            int si = queries[i][0];           // Updating the range of difference array  
            int ei = queries[i][1];
            int val = queries[i][2];

            diff[si] = diff[si] - val;
            if (ei+1 < n)
                diff[ei+1] = diff[ei+1] + val;
        }

        for (int i = 1; i < n; i++) {
            diff[i] = diff[i] + diff[i-1];
        }

        // -ve element will show that it is possible but +ve will show it is not possible
        for (int val : diff) {
            if (val > 0)                       
                return false;
        }

        return true;    
    }
    public boolean allZero(int[] nums) {
        for (int num : nums) {
            if (num != 0)
                return false;
        }
        return true;    
    }
}