class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
    // Approach 1: Try all possible subarrays (using 2 loops)
    
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == target)
                    cnt++;
                if (cnt > (j-i+1)/2)
                    ans++;
            }
        }

        return ans;
    }
}