class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long sum = 0;
        long cnt = 0;

        int si = 0, ei = 0;
        while (ei < n) {
            sum += nums[ei];

            while (sum * (ei-si+1) >= k && si <= ei) {
                sum -= nums[si];
                si++;
            }

            cnt += ei-si+1;
            ei++;
        }

        return cnt;
    }
}