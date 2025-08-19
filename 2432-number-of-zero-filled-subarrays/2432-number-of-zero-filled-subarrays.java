class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long count = 0;
        int i = 0, j = 0;
        while (i < n) {
            if (nums[i] != 0) {
                i++;
                continue;
            }
            j = i;
            while (j < n && nums[j] == 0) {
                j++;
            }
            count += (1L * (j-i) * (j-i+1)) / 2;
            i = j;
        }
        return count;
    }
}