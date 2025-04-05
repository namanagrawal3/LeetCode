class Solution {
    int sum;
    public int subsetXORSum(int[] nums) {
        sum = 0;
        subsetFun(nums, 0, 0);

        return sum;
    }
    public void subsetFun(int[] nums, int idx, int xor) {
        if (idx == nums.length) {
            sum += xor;
            return;
        }

        subsetFun(nums, idx + 1, xor ^ nums[idx]);
        subsetFun(nums, idx + 1, xor);
    }
}