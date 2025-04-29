class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxElement = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > maxElement)
                maxElement = nums[i];
        }

        long totalSubarrays = (1L * n * (n+1)) / 2;
        long count = 0;                 // stores the no. of subarrays where max element appears less than k times 
        int occur = 0;
        int si = 0, ei = 0;
        
        while (ei < n) {
            if (nums[ei] == maxElement)
                occur++;
            while (occur >= k && si <= ei) {
                if(nums[si] == maxElement)
                    occur--;
                si++;
            }

            count += ei-si+1;
            ei++;
        }

        return totalSubarrays - count;
    }
}