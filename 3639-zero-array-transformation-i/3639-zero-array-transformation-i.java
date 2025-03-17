class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
    // For range-updation queries, we will use 'Difference Array' technique

        int n = nums.length;
        int[] diff = new int[n];              // creating the difference array
        diff[0] = nums[0];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i-1];
        }

        for (int[] query : queries) {
            int si = query[0];                // Updating the range of difference array  
            int ei = query[1];
            diff[si]--;
            if (ei+1 < n)
                diff[ei+1]++;
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
}