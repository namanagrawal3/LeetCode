class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
    // Use the 'Sliding Window' approach for finding the 'longest subarray' which is good
        
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;

        int si = 0, ei = 0;
        while (ei < n) {
            map.put(nums[ei], map.getOrDefault(nums[ei], 0) + 1);

            while (si <= ei && map.get(nums[ei]) > k) {
                map.put(nums[si], map.get(nums[si]) - 1);
                if (map.get(nums[si]) == 0)
                    map.remove(nums[si]);
                si++;
            }

            maxLen = Math.max(maxLen, ei-si+1);
            ei++;
        }

        return maxLen;
    }
}