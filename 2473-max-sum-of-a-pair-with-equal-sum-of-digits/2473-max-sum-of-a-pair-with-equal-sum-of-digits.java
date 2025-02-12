class Solution {
    public int maximumSum(int[] nums) {
        int[] sum = new int[82];            // digitSum(999999999) --> 81
        int maxSum = -1;

        for (int num : nums) {
            int idx = digitSum(num);
            if (sum[idx] != 0)
                maxSum = Math.max(maxSum, sum[idx] + num);

            sum[idx] = Math.max(sum[idx], num);
        }
        
        return maxSum;
    }
    public int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
}