class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for (int i = n-1; i >= 0; i--) {
            set.add(nums[i]);
            suf[i] = set.size();
        }

        set.clear();
        int[] ans = new int[n];

        for (int i = 0; i < n-1; i++) {
            set.add(nums[i]);
            ans[i] = set.size() - suf[i+1];
        }
        set.add(nums[n-1]);
        ans[n-1] = set.size();

        return ans;
    }
}