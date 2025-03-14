class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 1;
        int si = 0, ei = 0;

        while (ei < nums.length) {
            map.put(nums[ei], map.getOrDefault(nums[ei], 0) + 1);

            while (map.get(nums[ei]) > k && si <= ei) {
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