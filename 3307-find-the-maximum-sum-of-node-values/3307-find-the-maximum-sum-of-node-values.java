class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int cnt = 0;
        int minLoss = Integer.MAX_VALUE;

        for (int num: nums) {
            if ((num ^ k) > num) {
                sum += (num ^ k);
                cnt++;
            }
            else 
                sum += num;

            minLoss = Math.min(minLoss, Math.abs(num - (num ^ k)));
        }

        if (cnt % 2 == 0)
            return sum;
        return sum - minLoss; 
    }
}