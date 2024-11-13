class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        long count = 0;

        for (int i = 0; i < n; i++) {
            int min = lower - nums[i];
            int max = upper - nums[i];

            int lb = lowerBound(nums, i+1, n-1, min);
            int ub = upperBound(nums, i+1, n-1, max);

            count += ub-lb+1;
        }

        return count;
    }
    public static int lowerBound(int[] nums, int si, int ei, int target) {
        while (si <= ei) {
            int mid = si+(ei-si)/2;
            if (nums[mid] >= target) 
                ei = mid - 1;
            else 
                si = mid + 1;
        }
        return si;
    }
    public static int upperBound(int[] nums, int si, int ei, int target) {
        while (si <= ei) {
            int mid = si+(ei-si)/2;
            if (nums[mid] <= target) 
                si = mid + 1;
            else 
                ei = mid - 1;
        }
        return ei;
    }
}