class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int n = nums.length;
        Arrays.sort(nums);

        int si = 1;
        int ei = nums[n-1];
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (isPossible(nums, mid, maxOperations))
                ei = mid - 1;
            else
                si = mid + 1;
        }
        
        return si;
    }
    public boolean isPossible(int[] nums, int penalty, int k) {
        int opr = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= penalty)
                continue;

            if (nums[i] % penalty == 0)
                opr += nums[i]/penalty - 1;
            else
                opr += nums[i]/penalty;

            if (opr > k)
                return false;
        }
        return true;
    }
}