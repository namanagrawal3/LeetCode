class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0)
                nums[i] = 0;
            else
                nums[i] = 1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int cnt = 0;
        int currSum = 0;

        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            int rem = currSum - k;
            if (map.containsKey(rem))
                cnt += map.get(rem);
            
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return cnt;
    }
}