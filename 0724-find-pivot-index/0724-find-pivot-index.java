class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int curr = 0;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
            if (curr == sum)
                return i;
            curr += nums[i];
        }

        return -1;
    }
}