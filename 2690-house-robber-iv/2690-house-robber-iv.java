class Solution {
    public int minCapability(int[] nums, int k) {
        int max = nums[0];
        for (int i = 0; i <nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int si = 0;
        int ei = max;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (isPossible(mid, nums, k))
                ei = mid - 1;
            else
                si = mid + 1;
        }

        return si;
    }
    public boolean isPossible(int capability, int[] nums, int k) {
        int count = 0;
        int j = -2, i = 0;
        while (i < nums.length) {
            if (nums[i] <= capability && i-j > 1) {
                count++;
                j = i;
            }

            if (count >= k)
                return true;
            i++;
        }
        
        return false;
    }
}