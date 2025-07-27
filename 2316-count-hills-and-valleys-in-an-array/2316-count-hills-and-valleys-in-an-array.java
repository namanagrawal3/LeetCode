class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int cnt = 0;

        for (int i = 1; i < n-1; i++) {
            if (nums[i] == nums[i-1])
                continue;
            int lnbr = lnbrFun(nums, i);
            int rnbr = rnbrFun(nums, i);

            if (lnbr == -1 || rnbr == -1)
                continue;
            if ((nums[i] > lnbr && nums[i] > rnbr) || (nums[i] < lnbr && nums[i] < rnbr))
                cnt++;
        }

        return cnt;
    }
    public int lnbrFun(int[] nums, int idx) {
        for (int i = idx-1; i >= 0; i--) {
            if (nums[i] != nums[idx])
                return nums[i];
        }
        return -1;
    }
    public int rnbrFun(int[] nums, int idx) {
        for (int i = idx+1; i < nums.length; i++) {
            if (nums[i] != nums[idx])
                return nums[i];
        }
        return -1;
    }
}