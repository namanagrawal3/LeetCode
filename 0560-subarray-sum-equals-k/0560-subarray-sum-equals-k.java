class Solution {
    public int subarraySum(int[] nums, int k) {
    // 'Sliding Window' will not work here  {[10,2,-2,-20,10], k=-10 --> 3}
    // 'Prefix-Sum usng Hashmap' will work  {currSum = rem + k}

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int currSum = 0;
        int count = 0;

        for (int num : nums) {
            currSum += num;
            int rem = currSum - k;
            if (map.containsKey(rem))
                count += map.get(rem);

            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}