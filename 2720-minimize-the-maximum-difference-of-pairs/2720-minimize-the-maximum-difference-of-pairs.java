class Solution {
    public int minimizeMax(int[] nums, int p) {
    // Clearly, we have to minimize the maximum difference, ie, min-max problem
    // thus, use 'Binary Search' similar to "Painter's-Partion" Problem
    
        if (p == 0)
            return 0;
            
        int n = nums.length;
        Arrays.sort(nums);

        int si = 0;
        int ei = nums[n-1] - nums[0];
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (isPossible(mid, nums, p))
                ei = mid - 1;
            else
                si = mid + 1;
        }

        return si;
    }
    public boolean isPossible(int diff, int[] nums, int p) {
        int n = nums.length;
        int cnt = 0;
        int i = 0;

        while (i < n-1) {
            if (nums[i+1] - nums[i] <= diff) {
                cnt++;
                i += 2;
            }
            else
                i++;

            if (cnt == p)
                return true;
        }
        return false;
    }
}