class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return true;
        if (nums[0] % 2 == 0) {                         // even
            for (int i = 2; i < n; i += 2) {
                if (nums[i] % 2 != 0)
                    return false;
            }
            for (int i = 1; i < n; i += 2) {
                if (nums[i] % 2 == 0)
                    return false;
            }
            return true;
        }
        else {                                          // odd
            for (int i = 2; i < n; i += 2) {
                if (nums[i] % 2 == 0)
                    return false;
            }
            for (int i = 1; i < n; i += 2) {
                if (nums[i] % 2 != 0)
                    return false;
            }
            return true;
        }
    }
}