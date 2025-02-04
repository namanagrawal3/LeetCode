class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int maxSum = 0;

        int si = 0, ei = 1;
        int sum = nums[0];
        while (ei < n) {
            if (nums[ei] > nums[ei-1])
                sum += nums[ei];
            else {
                maxSum = Math.max(maxSum, sum);
                si = ei;
                sum = nums[ei];
            }

            ei++; 
        }

        maxSum = Math.max(maxSum, sum);
        return maxSum;
    }
}