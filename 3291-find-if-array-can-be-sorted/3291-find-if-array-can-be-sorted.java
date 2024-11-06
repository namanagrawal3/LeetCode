class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if (nums[j] > nums[j+1]) {
                    if (Integer.bitCount(nums[j]) == Integer.bitCount(nums[j+1])) {
                        // swap the values
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                    }
                    else
                        return false;
                }
            }
        }
        return true;
    }
}