class Solution {
    public int smallestBalancedIndex(int[] nums) {
    // Simply, use the 'Prefix Sum' concept
        int n = nums.length;

        long preSum = 0L;
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
        }

        long sufProd = 1L;
        for (int i = n-1; i >= 0; i--) {
            preSum -= nums[i];
            if (preSum == sufProd)
                return i;
            
            if (sufProd > preSum/nums[i])   // prod now will increase, while sum will decrease
                break;
            sufProd *= nums[i];
        }

        return -1;
    }
}