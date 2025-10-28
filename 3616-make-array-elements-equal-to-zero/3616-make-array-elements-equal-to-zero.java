class Solution {
    public int countValidSelections(int[] nums) {
    // Approach: A start pos (nums[pos] == 0) is valid if -
    // either sum of its left & right parts are equal, thus increment by 2(ie,both directions)   
    // or, sum of its left & right differs by 1, thus increment by 1(ie, only 1 direction)

        int n = nums.length;
        int suff = 0;
        int pref = 0;
        for (int num: nums) {
            suff += num;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            suff -= nums[i];
            if (nums[i] == 0) {
                if (pref == suff)
                    ans += 2;
                else if (Math.abs(pref - suff) == 1)
                    ans++;
            }
            pref += nums[i];
        }

        return ans;
    }
}