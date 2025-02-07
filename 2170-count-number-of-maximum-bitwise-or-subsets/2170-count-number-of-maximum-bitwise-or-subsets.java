class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        for (int num : nums) {
            maxOR = maxOR | num;
        }

        return countFun(nums, maxOR, 0, 0);
    }
    public static int countFun(int[] nums, int maxOR, int currOR, int idx) {
        if (idx == nums.length) {
            if (currOR == maxOR)
                return 1;
            return 0;
        }

        int take = countFun(nums, maxOR, currOR|nums[idx], idx+1);
        int notTake = countFun(nums, maxOR, currOR, idx+1);

        return take + notTake;
    }
}