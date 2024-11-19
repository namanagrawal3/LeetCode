class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        long maxSum = 0;
        long sum = 0;

        int si = 0, ei = 0;
        while (ei < n) {
            sum += nums[ei];
            map.put(nums[ei], map.getOrDefault(nums[ei], 0) + 1);

            while (ei-si+1 > k && si <= ei) {
                sum -= nums[si];
                map.put(nums[si], map.get(nums[si]) - 1);
                if (map.get(nums[si]) == 0)
                    map.remove(nums[si]);
                si++;
            }

            if (ei-si+1 == k && map.size() == k)
                maxSum = Math.max(maxSum, sum);
            
            ei++;
        }
        return maxSum;
    }
}