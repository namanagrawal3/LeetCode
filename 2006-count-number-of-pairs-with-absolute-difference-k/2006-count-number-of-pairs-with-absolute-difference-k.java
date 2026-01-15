class Solution {
    public int countKDifference(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int req1 = nums[i] - k;
            int req2 = nums[i] + k;

            if (map.containsKey(req1))
                cnt += map.get(req1);
            if (map.containsKey(req2))
                cnt += map.get(req2);

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return cnt;
    }
}