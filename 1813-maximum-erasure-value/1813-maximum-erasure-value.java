class Solution {
    public int maximumUniqueSubarray(int[] nums) {
    // Simply find the max-sum of subarray containing distinct elements (Sliding Window)

        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSum = 0;
        int currSum = 0;

        int si = 0, ei = 0;
        while (ei < n) {
            currSum += nums[ei];
            map.put(nums[ei], map.getOrDefault(nums[ei], 0) + 1);

            while (map.size() < ei-si+1 && si <= ei) {
                currSum -= nums[si];
                map.put(nums[si], map.get(nums[si]) - 1);
                if (map.get(nums[si]) == 0)
                    map.remove(nums[si]);
                si++;
            }

            maxSum = Math.max(maxSum, currSum);
            ei++;
        }

        return maxSum;
    }
}